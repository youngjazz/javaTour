package concurrency.deeplearning.creatthread;

import java.util.stream.Stream;

/**
 * description: 创建线程, 初识线程组
 *
 * 如果不指定线程组, 集成其父线程的组
 *
 * @author 张洋
 * @date: 2019-05-13 23:51
 * @modified By:
 */
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        System.out.println(t.getThreadGroup());
        System.out.println(Thread.currentThread().getName());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup);

        System.out.println("---------遍历threadGroup中active线程------------");
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        Stream.of(threads).forEach(System.out::println);
    }
}
