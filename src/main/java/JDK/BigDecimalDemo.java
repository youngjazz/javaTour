package JDK;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_CEILING;

/**
 * Created by zhangyang on 2017/9/14.
 */
public class BigDecimalDemo {
	public static void main(String[] args) {
		BigDecimal bigDecimal1 = new BigDecimal(1);

		BigDecimal bigDecimal2 = new BigDecimal(3);

		System.out.println(bigDecimal1.divide(bigDecimal2,10,ROUND_CEILING).setScale(2,BigDecimal.ROUND_HALF_UP));
	}
}
