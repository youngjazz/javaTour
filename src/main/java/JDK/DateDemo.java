package JDK;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/12/28 14:06
 */
public class DateDemo {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		date = DateUtils.addDays(date,-1);
		System.out.println(DateFormatUtils.format(date, "/'y'=yyyy/'m'=M/'d'=d/*"));
		
		
	}
	

}
