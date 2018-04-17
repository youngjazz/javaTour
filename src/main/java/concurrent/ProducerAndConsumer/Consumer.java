package concurrent.ProducerAndConsumer;

/**
 * Created by leon on 2017/6/5.
 */
public class Consumer implements Runnable{
    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    public void run() {
        while (true) {
            synchronized (container){
                if(container.currentSize > 0){
                    container.notify();
                    container.currentSize--;
                    System.out.println("正在被消费。。。-1，当前剩余数量："+container.currentSize);
                }else {
                    System.out.println("容器已经空了。。。等待生产");
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
