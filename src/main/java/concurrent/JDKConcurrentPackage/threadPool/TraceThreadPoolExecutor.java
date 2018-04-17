package concurrent.JDKConcurrentPackage.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/7 16:47
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        /**
         * 错误堆栈可以看到在哪里提交的任务
         */
        for (int i = 0; i < 5; i++) {
            pool.execute(new DivTask(100, i));
        }
    }

    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                   BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(wrap(task, new Exception("Client stack trace"), Thread.currentThread().getName()));
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }
}
