package util;

import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.config.*;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.CodingErrorAction;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

	private final static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	private static String defaultCharset = "UTF-8";
    // 设置请求超时，默认3秒
	private static int soTimeout = 30000;
		
	// 设置连接超时时间，单位毫秒，默认5秒
	private static int connectionTimeout = 15000;
		
	// 设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的
	private static int connectionRequestTimeout = 30000;

	private static PoolingHttpClientConnectionManager connManager = null;
	private static CloseableHttpClient httpclient = null;

	static {
		try {
			SSLContext sslContext = SSLContexts.custom().useTLS().build();
			sslContext.init(null, new TrustManager[] { new X509TrustManager() {

				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			} }, null);

			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", new SSLConnectionSocketFactory(sslContext)).build();

			connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			httpclient = HttpClients.custom().setConnectionManager(connManager).build();
			// Create socket configuration
			SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(connectionTimeout).setTcpNoDelay(true).build();
			connManager.setDefaultSocketConfig(socketConfig);
			// Create message constraints
			MessageConstraints messageConstraints = MessageConstraints.custom().setMaxHeaderCount(200)
					.setMaxLineLength(2000).build();
			// Create connection configuration
			ConnectionConfig connectionConfig = ConnectionConfig.custom()
					.setMalformedInputAction(CodingErrorAction.IGNORE)
					.setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
					.setMessageConstraints(messageConstraints).build();
			connManager.setDefaultConnectionConfig(connectionConfig);
			connManager.setMaxTotal(200);
			connManager.setDefaultMaxPerRoute(20);
		} catch (KeyManagementException e) {
			logger.error("KeyManagementException", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException", e);
		}
	}



	/**
	  * <p>方法说明:获取HttpClient.</p> 
	  * <p>创建时间:2016年9月19日下午1:21:13</p>
	  * <p>作者: 刘永.</p>
	  * @param url
	  * @return
	  * @throws Exception CloseableHttpClient
	  */
	private static CloseableHttpClient getHttpClient(String url) throws Exception{
		
		URL uRL = new URL(url);
		CloseableHttpClient httpclient = null;
		if ("https".equals(uRL.getProtocol())) {
			SSLContext sslContext = new SSLContextBuilder()
					.loadTrustMaterial(null, new org.apache.http.conn.ssl.TrustStrategy() {
						public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
							// 信任所有
							return true;
						}
					}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(soTimeout)
					.setConnectTimeout(connectionTimeout).setConnectionRequestTimeout(connectionRequestTimeout).build();
			
			httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).setSSLSocketFactory(sslsf)
					.build();
		} else {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(soTimeout)
					.setConnectTimeout(connectionTimeout).setConnectionRequestTimeout(connectionRequestTimeout).build();
			httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
		}
		return httpclient;
	}
	/**
	 * HTTP请求，默认超时为5S
	 * 
	 * @param reqURL
	 * @param params
	 * @return
	 */
	public static String connectPostHttps(String reqURL, Map<String, String> params) {

		String responseContent = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;

		HttpPost httpPost = new HttpPost(reqURL);
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(soTimeout)
					.setConnectTimeout(connectionTimeout).setConnectionRequestTimeout(connectionRequestTimeout).build();

			List<NameValuePair> formParams = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));
			httpPost.setConfig(requestConfig);

			response = httpclient.execute(httpPost);
			logger.info("request url [{}] params [{}] httpStatus[{}]", reqURL, params,
					response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 执行POST请求
				entity = response.getEntity(); // 获取响应实体
				if (null != entity) {
					responseContent = EntityUtils.toString(entity, Consts.UTF_8);
				}
				logger.info("request url [{}] params [{}] responseContent[{}]", reqURL, params, responseContent);
			}
		} catch (Exception e) {
			logger.error("request url[" + reqURL + "] error params [" + params + "]", e);
		} finally {
			closeConnection(entity, response, httpPost);
		}
		return responseContent;
	}
	
	public static String httpPost(String url, String xmlParam)
			throws ConnectTimeoutException, SocketTimeoutException, IOException, GeneralSecurityException {

		return httpPost(url, xmlParam, defaultCharset);
	}

	public static String httpPost(String url, String xmlParam,String charset)
			throws ConnectTimeoutException, SocketTimeoutException, IOException, GeneralSecurityException {
		CloseableHttpClient httpclient = null;
		HttpPost httpPost = null;
		CloseableHttpResponse response = null;
		try {
			httpPost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connectionTimeout).setConnectTimeout(connectionRequestTimeout)
					.build();// 设置请求和传输超时时间
			httpPost.setConfig(requestConfig);
			httpPost.setEntity(new StringEntity(xmlParam,charset));
			if (url.startsWith("https")) {
				httpclient = createSSLInsecureClient();// 执行 Https 请求.
			} else {
				httpclient = HttpClientUtils.httpclient;// 执行 Http 请求.
			}
			response = httpclient.execute(httpPost);
			if(response.getStatusLine().getStatusCode()  != HttpStatus.SC_OK){
				throw new IOException("http response status error");
			}
			String jsonStr = EntityUtils.toString(response.getEntity(), charset);
			return jsonStr;
		} finally {
			httpPost.releaseConnection();
			if (httpclient != null) {
				httpclient.close();
			}
			if (response != null) {
				response.close();
			}
		}
	}
	
	private static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}

				public void verify(String host, SSLSocket ssl) throws IOException {
				}

				public void verify(String host, X509Certificate cert) throws SSLException {
				}

				public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
				}

			});
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (GeneralSecurityException e) {
			throw e;
		}
	}

	/**
	 * HTTP请求，默认超时为5S
	 * 
	 * @param reqURL
	 * @param params
	 * @return
	 */
	public static String connectPostHttps(String reqURL) {

		String responseContent = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;

		HttpPost httpPost = new HttpPost(reqURL);
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(soTimeout)
					.setConnectTimeout(connectionTimeout).setConnectionRequestTimeout(connectionRequestTimeout).build();
			httpPost.setConfig(requestConfig);
			response = httpclient.execute(httpPost);
			logger.info("request url [{}] httpStatus[{}]", reqURL, response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 执行POST请求
				entity = response.getEntity(); // 获取响应实体
				if (null != entity) {
					responseContent = EntityUtils.toString(entity, Consts.UTF_8);
				}
				logger.info("request url [{}] responseContent[{}] ", reqURL, responseContent);
			}
		} catch (Exception e) {
			logger.error("request url error" + reqURL, e);
		} finally {
			closeConnection(entity, response, httpPost);
		}
		return responseContent;
	}

	private static void closeConnection(HttpEntity entity, CloseableHttpResponse response, HttpPost httpPost) {
		try {
			if (entity != null) {
				entity.getContent().close();
			}
			if (response != null) {
				response.close();
			}
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		httpPost.releaseConnection();
	}
	
	/**
	  * <p>方法说明:执行Http请求返回Response.</p> 
	  * <p>创建时间:2016年9月19日下午1:28:41</p>
	  * <p>作者: 刘永.</p>
	  * @param paramList
	  * @return
	  * @throws Exception HttpResponse
	  */
	public static HttpResponse  httpExecute(List<NameValuePair> paramList, String url) throws Exception {
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("Accept","application/json");
		httpost.setEntity(new UrlEncodedFormEntity(paramList,"utf-8"));
		
		CloseableHttpClient httpclient= getHttpClient(url);
		return httpclient.execute(httpost);
	}

	public static void main(String[] args) throws IOException {

		String url = "http://www.baidu.com";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("url", "http://www.baidu.com");
//		String content = connectPostHttps("http://dwz.cn/create.php", params);
//		System.out.println(content);

		HttpHead head = new HttpHead(url);
		HttpResponse response = httpclient.execute(head);
		System.out.println(JSON.toJSON(response));

		HttpTrace trace = new HttpTrace(url);
//		response = httpclient.execute(trace);
//		System.out.println(JSON.toJSON(response));

		HttpOptions options = new HttpOptions(url);
		response = httpclient.execute(options);
		System.out.println(JSON.toJSON(response));
	}

}
