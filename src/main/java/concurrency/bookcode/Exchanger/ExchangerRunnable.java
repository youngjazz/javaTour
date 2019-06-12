package concurrency.bookcode.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by leon on 2017/6/12.
 */
public class ExchangerRunnable implements Runnable {

    Exchanger exchanger = null;
    Object object = null;

    public ExchangerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    @Override
    public void run() {
        Object previous = this.object;
        try {
            this.object = this.exchanger.exchange(this.object);
            System.out.println(Thread.currentThread().getName()+" exchanged "+
            previous+ " for "+ this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
