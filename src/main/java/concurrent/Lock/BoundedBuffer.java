package concurrent.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by leon on 2017/6/13.
 */
public class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notEmty = lock.newCondition();
    final Condition notFull = lock.newCondition();

    //缓存队列
    final Object[] items = new Object[100];
    int putIndex; //写索引
    int takeIndex; //读索引
    int count;//数量
    //写
    public void put(Object object) throws InterruptedException {
        lock.lock(); //锁定

        try{
            //队列满，阻塞写线程
            if(count == items.length){
                notFull.await();
            }

            //写入队列，更新索引
            items[putIndex] = object;
            putIndex++;

            //唤醒读线程
            notEmty.signal();
        } finally{
            lock.unlock();
        }

    }
}
