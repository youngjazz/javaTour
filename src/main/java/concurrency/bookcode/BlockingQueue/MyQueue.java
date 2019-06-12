package concurrency.bookcode.BlockingQueue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by leon on 2017/7/24.
 */
public class MyQueue {
    //1. 需要一个集合，承接元素
    private final LinkedList<Object> list = new LinkedList<Object>();

    //2. 指定上下界
    private final int min = 0;

    private final int max;

    private final  int default_length = 12;

    //3.计数器
    private AtomicLong counter = new AtomicLong(0);

    //4.定义锁对象
    private final Object lock = new Object();

    public MyQueue(int max) {
        this.max = max;
    }

    public void put(Object obj){
        synchronized (lock) {
            while(counter.get()==max){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.add(obj);
            counter.incrementAndGet();
            System.out.println("新加入的元素为："+obj);

            //唤醒另外一个线程
            lock.notify();
        }
    }

    public Object take(){
        Object ret = null;
        synchronized (lock) {
            while (counter.get()==min){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //移除元素
            ret = list.removeFirst();
            System.out.println("去除元素："+ret);
            //计数器递减
            counter.decrementAndGet();
            //唤醒其他线程
            lock.notify();
        }

        return ret;
    }


    public long getSize(){
        return this.counter.get();
    }

    public static void main(String[] args) {
        final MyQueue mq = new MyQueue(10);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    mq.put("key"+i);
                }
            }
        });
        t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    Object ret =  mq.take();
                }
            }
        });
        t2.start();
    }
}
