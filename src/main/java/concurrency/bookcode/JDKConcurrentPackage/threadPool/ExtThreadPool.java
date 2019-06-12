package concurrency.bookcode.JDKConcurrentPackage.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION：扩展线程池
 *
 * @author zhangyang 2018/4/7 15:06
 */
public class ExtThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()){
	        @Override
	        protected void beforeExecute(Thread t, Runnable r) {
		        System.out.println("准备执行："+ t.getName());
	        }
	
	        @Override
	        protected void afterExecute(Runnable r, Throwable t) {
		        System.out.println("执行完毕："+ ((Mytask) r).getName());
	        }
	
	        @Override
	        protected void terminated() {
		        System.out.println("线程池退出");
	        }
        };
	
	    for (int i = 0; i < 5; i++) {
		    Mytask task = new Mytask("task-geym-"+i);
		    es.execute(task);
		    Thread.sleep(10);
	    }
	    
	    es.shutdown();
    }

    public static class Mytask implements Runnable {
        private String name;
	
	    public Mytask(String name) {
		    this.name = name;
	    }
	
	    @Override
        public void run() {
            System.out.println("正咋执行：thread id:" + Thread.currentThread().getId() + " task name:" + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }
}
