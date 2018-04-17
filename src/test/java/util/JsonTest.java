package util;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Date;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/12/8 17:57
 */
public class JsonTest {
	@Test
	public void json2String(){
		JSONObject json = new JSONObject();
		json.put("name","张洋");
		json.put("age",27);
		json.put("now",new Date());
		
		System.out.println(json);
		System.out.println(json.toString());
		System.out.println(json.toJSONString());
	}
}
