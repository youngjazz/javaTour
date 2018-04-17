package concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by leon on 2017/6/29.
 */
public class MyThread extends Thread{

    private CountDownLatch maxRunner;

    public MyThread(CountDownLatch maxRunner) {
        super();
        this.maxRunner = maxRunner;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            maxRunner.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch maxRunner = new CountDownLatch(10);
        MyThread[] tArray = new MyThread[Integer.parseInt(""+maxRunner.getCount())];

        for (int i = 0; i < tArray.length; i++) {
            tArray[i] = new MyThread(maxRunner);
            tArray[i].setName("线程"+(i+1));
            tArray[i].start();
        }

        maxRunner.await();
        System.out.println("都回来了！");
    }
}
