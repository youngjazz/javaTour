package concurrency.bookcode.SemaPhore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by leon on 2017/6/9.
 */
public class RepastService {
    volatile private Semaphore setSemaphore = new Semaphore(10); //厨师
    volatile private Semaphore getSemaphore = new Semaphore(20); //就餐者
    volatile private ReentrantLock lock = new ReentrantLock();
    volatile private Condition setCondition = lock.newCondition();
    volatile private Condition getCondition = lock.newCondition();

    //producePosition 变量表示最多只有4个盒子存放菜品
    volatile private Object[] productPosition = new Object[4];

    private boolean isEmpty(){
        boolean isEmpty = true;
        for (int i = 0; i < productPosition.length; i++){
            if(productPosition[i] != null){
                isEmpty = false;
                break;
            }
        }

        if(isEmpty == true){
            return true;
        }else
            return false;
    }

    private boolean isFull(){
        boolean isFull = true;
        for (int i = 0; i < productPosition.length; i++) {
            if (productPosition[i] == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void set(){
        try {
            setSemaphore.acquire();
            lock.lock();
            while (isFull()){
                //生产者等待
                setCondition.await();
            }
            for (int i = 0; i < productPosition.length; i++) {
                if (productPosition[i]==null){
                    productPosition[i] = "数据";
                    System.out.println(Thread.currentThread().getName()+" 生产了 "+productPosition[i]);
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setSemaphore.release();
        }
    }

    public void get(){
        try {
            getSemaphore.acquire(); //允许最多16个人同时就餐
            lock.lock();
            while(isEmpty()){
                getCondition.await();
            }
            for (int i = 0; i < productPosition.length; i++) {
                if(productPosition[i] != null){
                    System.out.println(Thread.currentThread().getName()+" 消费了 "+productPosition[i]);
                    productPosition[i] = null;
                    break;
                }
            }
            setCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            getSemaphore.release();
        }
    }
}
