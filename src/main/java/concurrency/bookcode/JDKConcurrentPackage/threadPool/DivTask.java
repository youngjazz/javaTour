package concurrency.bookcode.JDKConcurrentPackage.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION：堆栈哪里去了？
 *
 * @author zhangyang 2018/4/7 15:51
 */
public class DivTask implements Runnable {

    int a, b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a / b;
        System.out.println(re);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
	    ThreadPoolExecutor pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
	    for (int i = 0; i < 5; i++) {
//		    pool.submit(new DivTask(100,i)); //线程池会吃掉异常
//		    pool.execute(new DivTask(100,i));
		
		    //or like this
//		    Future re = pool.submit(new DivTask(100, i));
//		    re.get();
	    }
    }
}
