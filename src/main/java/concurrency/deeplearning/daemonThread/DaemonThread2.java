package concurrency.deeplearning.daemonThread;

/**
 * 守护线程T1 内部再起 守护线程T11， T1执行完毕，T11会退出吗？，
 *
 * @author 张洋
 * @date: 2019-10-07 17:17
 */
public class DaemonThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Thread t11 = new Thread(()->{
                while (true) {
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("health check success...");
                }
            });

//            t11.setDaemon(true);
            t11.start();

            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread t1 finished.");
        });
//        t1.setDaemon(true);
        t1.start();

    }
}
