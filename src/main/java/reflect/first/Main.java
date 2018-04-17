package reflect.first;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by zhangyang on 2017/9/6.
 */
public class Main {
	public static Map<String, Object> buildCreditCallbackParamsMap(Object callBackDTO)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map<String, Object> map = MapUtil.toMap(callBackDTO);
		map.put("serviceName", "testService");
		map.put("format", "UTF-8");

		return map;
	}

	public static void main(String[] args) {
		Student student = new Student(1,"张三");

		Clazz clazz = new Clazz("班级1","中级");

		try {
			Map map = buildCreditCallbackParamsMap(student);
			System.out.println(map);
			Map map1 = buildCreditCallbackParamsMap(clazz);
			System.out.println(map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
