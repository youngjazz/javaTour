package concurrency.bookcode.JDKConcurrentPackage.lockOptimat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/16 13:23
 */
public class ThreadLoclDemo {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();

    private static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Date d = sdf.parse("2018-04-01 19:29:"+i%60);
                System.out.println(i + ":" + d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static class ParseDate2 implements Runnable{
    	int i = 0;
	
	    public ParseDate2(int i) {
		    this.i = i;
	    }
	
	    @Override
	    public void run() {
		    if (tl.get()==null) {
			    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		    }
		    try {
			    Date t = tl.get().parse("2018-04-01 19:29:"+i%60);
			    System.out.println(i + ":" + t);
		    } catch (ParseException e) {
			    e.printStackTrace();
		    }
	    }
    }
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
			//es.execute(new ParseDate(i));
			es.execute(new ParseDate2(i));
		}
	}
}
