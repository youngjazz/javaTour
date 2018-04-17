package TypeConvert;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/2/7 17:49
 */
public class MapDemo {
	@Test
	public void test(){
		String str = "{\"12\":\"HH\"}";
		Map<Integer,String> map = (Map<Integer, String>) JSON.parse(str);
		System.out.println(map.get(12));
		System.out.println(map.get("12"));
		
		Map<Integer,String> map2 = new HashMap<Integer,String>();
		map2.get(12);
		map2.get("12");
		
	}
}
