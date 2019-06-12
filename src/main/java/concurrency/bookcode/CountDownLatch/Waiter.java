package concurrency.bookcode.CountDownLatch;

import java.util.concurrent.CountDownLatch;
/**
 * Created by leon on 2017/6/12.
 */
public class Waiter implements Runnable {

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("waiter released");
    }
}
