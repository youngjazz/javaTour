package concurrency.bookcode.SemaPhore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by leon on 2017/6/2.
 */
public class ListPOOL {
    private int poolMaxSize = 5;
    private int semaphorePermits = 3;
    private List<String> list = new ArrayList<String>();
    private Semaphore concurrencySemaphore = new Semaphore(semaphorePermits);

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public ListPOOL() {
        super();
        for (int i = 0; i < poolMaxSize; i++) {
            list.add("zy "+(i+1));
        }
    }

    public String get() {
        String getString = null;

        try {
            lock.lock();
            concurrencySemaphore.acquire();
            while (list.size()==0){
                condition.await();
            }
            getString = list.remove(0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        return getString;
    }

    public void put(String str){
        lock.lock();
        list.add(str);
        condition.signalAll();
        lock.unlock();
        concurrencySemaphore.release();
    }
}
