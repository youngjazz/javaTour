package concurrency.bookcode.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 实现裁判员等待所有运动员各就各位全部准备完毕，在开始比赛
 * Created by leon on 2017/6/29.
 */
public class OnYourMarks {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        PlayerThread[] threadArray = new PlayerThread[10];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new PlayerThread(service);
            threadArray[i].setName("线程"+(i+1));
            threadArray[i].start();
        }

        Thread.sleep(2000);
        service.down();
    }

}

class MyService {
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void action(){
        try {
            System.out.println(Thread.currentThread().getName() + "准备");
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+ "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void down(){
        System.out.println("比赛开始--------");
        countDownLatch.countDown();
    }
}

class PlayerThread extends Thread{
    private MyService myService;

    public PlayerThread(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.action();
    }
}