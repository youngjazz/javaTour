package concurrency.bookcode.ProducerAndConsumer;

/**
 * Created by leon on 2017/6/5.
 */
public class Producer implements Runnable {
    private Container container;

    public Producer(Container container) {
        this.container = container;
    }

    public void run() {
        while (true) {
            synchronized (container){
                //容器未满则生产
                if (container.currentSize < container.maxSize){
                    container.notify();//生产完则通知并释放锁
                    container.currentSize++;
                    System.out.println("生产者正在生产。。。+1，当前产数量："+container.currentSize);
                }else {
                    System.out.println("容器已经满了，生产者停止生产，等待被消费。。。");
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
