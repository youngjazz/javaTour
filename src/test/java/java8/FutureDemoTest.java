package java8;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 *
 * @author 张洋
 * @date: 2019-05-08 19:21
 * @modified By:
 */
public class FutureDemoTest {

    @Test
    public void getPriceAsync() throws ExecutionException, InterruptedException {
        FutureDemo futureDemo = new FutureDemo();
        Future<Double> futurePrice = futureDemo.getPriceAsync("apple");
        Double price = futurePrice.get();
        System.out.println(price);
    }
}