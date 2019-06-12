package concurrency.bookcode.ProducerAndConsumer;

/**
 * 多线程实现生产者消费者问题（wait/notify）
 * Created by leon on 2017/6/5.
 */
public class Container {
    public int maxSize; //定义最大容量
    public int currentSize;

    public Container(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
    }
}
