package java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/25 10:54
 */
public class DateApi {
	
    public static void main(String[] args) {
        //表示时刻的Instant
        Instant instant = Instant.now();
	    System.out.println(instant);
	    
	    Instant instant1 = Instant.ofEpochSecond(20);
	    System.out.println(instant1);
	    
	    Instant instant2 = Instant.ofEpochSecond(30, 100);
	    System.out.println(instant2);
	    
	    Instant instant3 = Instant.ofEpochSecond(1000);
	    System.out.println(instant3);
	
	    System.out.println("---------------处理日期的LocalData------------------");
	    LocalDate localDate = LocalDate.now();
	    System.out.println(localDate);
	    LocalDate localDate1 = LocalDate.of(2017,7,22);
	    System.out.println(localDate1);
	
	    LocalDate localDate2 = LocalDate.ofYearDay(2018, 100);
	    System.out.println(localDate2);
	
	    LocalDate localDate3 = LocalDate.ofEpochDay(10);
	    System.out.println(localDate3);
	
	    System.out.println("------------------处理时间--------------------");
	    System.out.println(LocalTime.now());
	    System.out.println(LocalTime.of(23,59));
	    System.out.println(LocalTime.ofSecondOfDay(70));
	
	    System.out.println("---------------格式化时间---------------");
	    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
	    System.out.println(formatter.format(LocalDateTime.now()));
    }
}
