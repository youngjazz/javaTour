package concurrency.bookcode.ProducerAndConsumer;

/**
 * Created by leon on 2017/6/5.
 */
public class TestProducerAndConsumer {
    public static void main(String[] args) {
        Container container = new Container(10);
        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);
        //启动生产者模式
        new Thread(producer,"producer").start();
        new Thread(consumer,"consumer").start();
    }
}
