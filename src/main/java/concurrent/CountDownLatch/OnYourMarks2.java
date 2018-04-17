package concurrent.CountDownLatch;

import org.joda.time.DateTime;

import java.util.concurrent.CountDownLatch;

/**
 * Created by leon on 2017/6/29.
 */
public class OnYourMarks2 {
    public static void main(String[] args) {
        CountDownLatch coming = new CountDownLatch(10);
        CountDownLatch waiting = new CountDownLatch(1);
        CountDownLatch waitRun = new CountDownLatch(10);
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(10);

        Players[] players = new Players[10];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Players(coming,waiting,waitRun,begin,end);
            players[i].start();
        }
        try {
            System.out.println("裁判等待选手到来");
            coming.await();
            System.out.println("裁判看到运动员到来，巡视5秒");
            Thread.sleep(5000);
            waiting.countDown();
            System.out.println("各就各位");
            waitRun.await();
            Thread.sleep(2000);
            System.out.println("发令枪响。。。");
            begin.countDown();
            end.await();
            System.out.println("所有运动员到达，统计名称");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Players extends Thread{
    private CountDownLatch coming;
    private CountDownLatch waiting;
    private CountDownLatch waitingRun;
    private CountDownLatch begin;
    private CountDownLatch end;

    public Players(CountDownLatch coming, CountDownLatch waiting, CountDownLatch waitingReturn, CountDownLatch running, CountDownLatch end) {
        super();
        this.coming = coming;
        this.waiting = waiting;
        this.waitingRun = waitingReturn;
        this.begin = running;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread()+"正在进入赛道...");
            Thread.sleep((int)(Math.random()*10000));
            System.out.println(Thread.currentThread().getName()+"到起跑点了");
            coming.countDown();
            System.out.println(Thread.currentThread().getName()+"等待裁判准备指令");
            Thread.sleep((int)(Math.random()*10000));
            waiting.await();
            System.out.println("各就各位`````````````````````````");
            Thread.sleep((int)(Math.random()*10000));
            waitingRun.countDown();
            begin.await();
            System.out.println(Thread.currentThread().getName()+"起跑, 用时不确定");
            Thread.sleep((int)(Math.random()*10000));
            end.countDown();
            System.out.println(Thread.currentThread()+"到达终点");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String now(){
        String now = DateTime.now().toString();
        return now;
    }
}