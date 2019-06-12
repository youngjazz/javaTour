package concurrency.bookcode.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by leon on 2017/6/12.
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        ExchangerRunnable exchangerRunnable1 =
                new ExchangerRunnable(exchanger,"A");
        ExchangerRunnable exchangerRunnable2 =
                new ExchangerRunnable(exchanger,"B");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
    }
}
