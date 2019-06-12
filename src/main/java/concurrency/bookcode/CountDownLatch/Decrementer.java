package concurrency.bookcode.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by leon on 2017/6/12.
 */
public class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("latch countDown");
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("latch countDown");
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("latch countDown");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
