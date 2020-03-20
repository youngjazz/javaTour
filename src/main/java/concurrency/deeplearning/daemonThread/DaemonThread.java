package concurrency.deeplearning.daemonThread;

/**
 * 守护线程
 *
 * @author 张洋
 * @date: 2019-10-07 16:52
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
                try {
                    Thread.sleep(5_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " done.");
            }
        };

        //如果将t设置为守护线程，如果main执行完毕，t无论是否执行完毕，程序会立即结束
        t.setDaemon(true);
        //默认是false 非守护线程，main线程执行完之后，程序不会立即退出，会等其他活跃非daemon线程执行完毕再退出

        //t runnable
        t.start();

        System.out.println(Thread.currentThread().getName() + " done.");
    }

    /**
     * 设置守护线程有什么用呢？
     *
     * 比如在A 与 B之间建立长链接，需要有线程定时去做心跳保持，如果A，B之间关闭了连接，这个心跳检查就没必要保持了
     * 那么这个心跳保持的线程应该设置为守护线程
     * A <----------------->B
     *
     */
}
