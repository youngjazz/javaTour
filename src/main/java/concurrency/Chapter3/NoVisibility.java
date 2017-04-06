package concurrency.Chapter3;

/**
 * 没有同步的情况下的共享内存，不要这么做
 * 在没有同步的情况下，编译器，处理器以及运行时等都可能对操作的执行顺序进行一些意想不到的调整。
 * 这种现象称之为"重排序（Reordering）"
 * Created by leon on 2017/4/5.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }


}
