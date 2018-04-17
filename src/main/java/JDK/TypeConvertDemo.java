package JDK;

import org.apache.commons.lang3.StringUtils;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/20 11:58
 */
public class TypeConvertDemo {
	public static void main(String[] args) {
		Object aa = null;
		String bb = (String)aa;
		System.out.println(bb);
		System.out.println(StringUtils.isBlank(bb));
	}
}
