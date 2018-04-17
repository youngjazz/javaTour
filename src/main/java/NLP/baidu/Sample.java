package NLP.baidu;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

/**
 * DESCRIPTION：百度NLP
 *
 * @author zhangyang 2018/1/22 14:08
 */
public class Sample {
	public static final String APP_ID = "10728089";
	public static final String API_KEY = "2BspOwKfOOv6LeWatszqb1Kk";
	public static final String SECRET_KEY = "Wfio84sfI35gNVXGssnq0hxQWY1vHg7D";
	
	public static void main(String[] args) {
		// 初始化一个AipNlp
		AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
		
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		// 调用接口
		String text = "百度是一家高科技公司";
		JSONObject res = client.lexer(text, null);
		System.out.println(res.toString(2));
	}
}
