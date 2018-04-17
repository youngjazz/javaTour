package concurrent.JDKConcurrentPackage.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION：自定义线程池和拒绝策略的使用
 *
 * @author zhangyang 2018/4/3 09:27
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
	                    System.out.println(r.toString()+"is discard...");
                    }
                });

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            threadPoolExecutor.submit(task);
            Thread.sleep(10);
        }
    }
}
