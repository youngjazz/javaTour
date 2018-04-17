package zaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.zhongan.scorpoin.common.ZhongAnApiClient;
import com.zhongan.scorpoin.common.dto.CommonRequest;
import com.zhongan.scorpoin.common.dto.CommonResponse;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/24 09:47
 */
public class FXJOpenServiceImplTest {
	String version = "1.0.0";
	String env = "iTest";
	String appkey = "bb55964dc7264106306b989faf7d0afe";
	String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALpmpKOSUXGjQrw9FY6BEuFhhXK+lF7/6HgTyxkR9+xk+SwIgz2hgA71VHbkJOdquI7iYGWPVOQcCJ62nLipWW7ZD8PG0NBdiZLrlggY99+1oHsXUNWpeaP1qpyIxjYVHR/AI0PjVRp4rHMRJCodml8JM8ZNBCt+thjzvyiERRINAgMBAAECgYEAinQJYHIjSpwwyq84ntPi2UPdoqBKhtHgs6hIGEQPeih6KCneid22x+WUKodFnhrYIVGmtmkjbhggkvsjJ8qqYPYRqb6ypZtfSpouPWKagscbxW+DcKvLAF0mwE1UlA1Qea7IXK4ReUX2Pnj08ykQUwLAiS6Zs9NFV30gv75CI0ECQQDdHOclp52E2gwHYVHtDS+Gcg+DbW8nuRuVgvOsy4u6Ekn/P6/CDjalJbxiHL7h0NR6C2rjH9A9BuvGsVub8OVRAkEA18+rg664tnH59bgRA+xM+0yKY2l55TSk4NXZYLsy02KZ+UZts10+cNhATyP2u24DpVunNGzKzdrv+E+MYrMh/QJAT2TNaqvg148jupKrRB7z7aaPA3YL74t76Bd5P5ZmuY1PnKNVjKxl2q7OEbyYnaTKZngrDRqjPwZ5KoMMjdXVwQJBAMjUBXzuTA/j8sMZ/iOTc3Prn2Cxl/CW09QyzS46JisWN8kEJDPk0qV6aCX9hq6WyyfHKcscboGwet2tUSvMHRUCQB0CtoZfuRDGIoLeWuyjDD+XvtOSweMc8bxhP2ihpX6dLX8ORMELN4iCz6FEBmO2lsP+FIHVFNQVyTk4t6oy4jA=";
	String url = "http://opengw-daily08.zhongan.com/Gateway.do";
	String signType = "RSAMD5";
	String salt = "TEST";
	String partner_id = "2600001";
	String partner_product_id = "2600002";
	@Test
	public void bankList() throws Exception {
		String serviceName = "com.zhongan.plutus.toutiao.service.bankList";


	}

	@Test
	public void creditApply() throws Exception {
		String serviceName = "com.zhongan.plutus.toutiao.service.creditApply";


		ZhongAnApiClient client = new ZhongAnApiClient(env, url, appkey, privateKey, version, signType);
		client.setSalt(salt);
		CommonRequest request = new CommonRequest(serviceName);
		JSONObject params = new JSONObject();
		params.put("partner_id", partner_id);
		params.put("partner_product_id", partner_product_id);


		request.setParams(params);

		CommonResponse response = (CommonResponse) client.call(request);
		System.out.println(response);
	}

	@Test
	public void bindCard() throws Exception {
	}

	@Test
	public void creditResult() throws Exception {
	}

	@Test
	public void userCreditInfo() throws Exception {
	}

	@Test
	public void uploadFile() throws Exception {
		String serviceName = "com.zhongan.plutus.toutiao.service.uploadFile";


		ZhongAnApiClient client = new ZhongAnApiClient(env, url, appkey, privateKey, version, signType);
		client.setSalt(salt);
		CommonRequest request = new CommonRequest(serviceName);

		String longText = getLongText("/Users/leon/temp/longJson.txt");
		JSONObject params = JSONObject.parseObject(longText);

		request.setParams(params);

		CommonResponse response = (CommonResponse) client.call(request);
		System.out.println(response);

	}

	@Test
	public void loanApply() throws Exception {
	}

	@Test
	public void loanProcess() throws Exception {
	}

	@Test
	public void repayPlanTrial() throws Exception {
	}

	@Test
	public void loanRecords() throws Exception {
	}

	@Test
	public void loanDetail() throws Exception {
	}

	@Test
	public void repayRecords() throws Exception {
	}

	@Test
	public void monthBill() throws Exception {
	}

	@Test
	public void repayPlan() throws Exception {
	}

	@Test
	public void allRepayTrial() throws Exception {
	}

	@Test
	public void allRepay() throws Exception {
	}

	@Test
	public void repaySubmit() throws Exception {
	}

	@Test
	public void repayProcess() throws Exception {
	}

	private static String getLongText(String path) throws IOException {
		String base64 = "";
		File file = new File(path);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = br.readLine()) != null) { //一次读取一行
				base64 += line;
			}
			br.close();
		}
		return base64;
	}
}