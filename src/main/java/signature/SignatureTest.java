package signature;

import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.PublicKey;



public class SignatureTest {
	
	
	public static void main(String[] args) {
		
		/*
		 *此内容为合作商 生成签名 和 阳光验证签名的方式  
		 *反之 阳光会用阳光私钥生成签名串    合作商用阳光公钥进行验证
		 */
		String verifyStr=
			"<Request>\n" +
			"\t<InputsList>\n" +
			"\t\t<Inputs type=\"vehicleInfo\">\n" +
			"\t\t\t<Input name=\"licenseNo\">冀A00021</Input>\n" +
			"\t\t\t<Input name=\"cityCode\">07518800</Input>\n" +
			"\t\t\t<Input name=\"noLicenseFlag\">0</Input>\n" +
			"\t\t</Inputs>\n" +
			"\t</InputsList>\n" +
			"</Request>";
		
		//生产签名串 和 验证类
		PartnerSignerImpl signer=new PartnerSignerImpl();
		
		//得到私钥
		PrivateKey ygPrivate = KeyPairer.getPrivateKey(KeyPairer.PARTNER_PRIVATE_KEY);

		//返回报文签名串  此字符传放入报文的<Sign>标签中
		String sign ="";
		try {
			sign = signer.sign(verifyStr.getBytes("GBK"), ygPrivate);
			System.out.println(sign);
			System.out.println("BE91S4UFNWXJ29kzJHnoP4qbI_enUkwkp87_dUePQlamba037iQrCTN0_-RcTg5FjD4gHl09eBBkxTRav7OYv0vF8EJiPvJbhVNKma5jgpOvtCHS1qZJWo0XTAawYWyMi6zJJZpO1r3YDc1OCLSNTWH53lZG46kaXV-UfmGIXpc");
		} catch (UnsupportedEncodingException e) {}
		//以上为生成签名串的方法
		
		//以下为验证发送报文签名一致的方法
		//获取公钥
		PublicKey aliPublicKey = KeyPairer.getPublicKey(KeyPairer.PARTNER_PUBLIC_KEY);
		//校验签名
		boolean signFlag = false;
		try {
			signFlag = signer.verify(verifyStr.getBytes("GBK"),sign, aliPublicKey);
		} catch (UnsupportedEncodingException e1) {}
		System.out.println("验证结果:"+signFlag);
	}
	
}
