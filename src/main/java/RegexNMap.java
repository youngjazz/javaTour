import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/20 16:36
 */
public class RegexNMap {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			map();
		}
		long end = System.currentTimeMillis();
		
		System.out.println("map 耗时："+(end - start));
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			regex();
		}
		end = System.currentTimeMillis();
		
		System.out.println("pattern 耗时："+(end - start));
	}
	
	private static void regex(){
		String url = "http://c.itest.zhongan.com/page/index.html?m=1&y=0&target=2&jui=ajiosdjiofaj&qw=jfksjkdfnjkan&mk=nakjdfjankjd&rt=1231231231";
		Pattern pattern = Pattern.compile("(http[^\\?]+)\\?*(\\S*)(target=[^\\&]+)(\\&*[\\S]*)$");
		Matcher matcher = pattern.matcher(url);
		String host = "";
		String tartget = "";
		String extra = "";
		if (matcher.find()) {
			host = matcher.group(1);
			tartget =  matcher.group(3);
			extra = matcher.group(2) + matcher.group(4);
		}
		
		
	}
	
	private static void map(){
		String url = "http://c.itest.zhongan.com/page/index.html?m=1&y=0&target=2&jui=ajiosdjiofaj&qw=jfksjkdfnjkan&mk=nakjdfjankjd&rt=1231231231";
		parseParams(url);
	}
	private static String parseParams(String referer) {
		Map<String, String> paramMap = new HashMap<String, String>();
		String[] arrTemp = null;
		String strAllParam = null;
		arrTemp = referer.split("[?]");
		if (referer.length() > 1 && arrTemp.length > 1) {
			if (arrTemp[1] != null) {
				strAllParam = arrTemp[1];
			}
		}
		if (strAllParam == null) {
			return null;
		}
		
		arrTemp = strAllParam.split("&");
		
		for (String strSplit : arrTemp) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("=");
			if (arrSplitEqual.length > 1) {
				//正确解析
				paramMap.put(arrSplitEqual[0], arrSplitEqual[1]);
				
			} else {
				if (arrSplitEqual[0] != "") {
					//只有参数没有值，不加入
					paramMap.put(arrSplitEqual[0], "");
				}
			}
		}
		return strAllParam;
	}
	
}