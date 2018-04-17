package concurrent.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 使用CyclicBarrier的计数重复性 实现多阶段比赛
 * Created by leon on 2017/6/29.
 */
public  class Race {
    public final static native int d();
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(2);

        Player player1 = new Player(barrier);
        player1.setName("A");
        player1.start();


        Player player2 = new Player(barrier);
        player2.setName("B");
        player2.start();


        Player player3 = new Player(barrier);
        player3.setName("C");
        player3.start();

        Player player4 = new Player(barrier);
        player4.setName("D");
        player4.start();

    }
}

class Player extends Thread{

    private CyclicBarrier barrier;

    public Player(CyclicBarrier barrier) {
        super();
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            long sleep = (int)(Math.random()*1000);
            Thread.sleep(sleep);
            System.out.println(Thread.currentThread().getName()+ " "+
            System.currentTimeMillis() + " begin 跑第1阶段 "+(barrier.getNumberWaiting()+1));
            barrier.await();
            System.out.println(Thread.currentThread().getName()+ " "+
                    System.currentTimeMillis() + " end 跑第1阶段 "+(barrier.getNumberWaiting()));

            sleep = (int)(Math.random()*1000);
            Thread.sleep(sleep);
            System.out.println(Thread.currentThread().getName()+ " "+
                    System.currentTimeMillis() + " begin 跑第2阶段 "+(barrier.getNumberWaiting()+1));
            barrier.await();
            System.out.println(Thread.currentThread().getName()+ " "+
                    System.currentTimeMillis() + " end 跑第2阶段 "+(barrier.getNumberWaiting()));


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
