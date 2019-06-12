package concurrency.bookcode.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by leon on 2017/6/28.
 */
public class ThreadA extends Thread {
    private Exchanger<String> exchanger;

    public ThreadA(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("在线程A中娶到线程B的值："+exchanger.exchange("中国aa",5,TimeUnit.SECONDS));
            System.out.println("线程A end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a = new ThreadA(exchanger);
        ThreadB b = new ThreadB(exchanger);
        a.start();
        b.start();
        System.out.println("main end");
    }
}

class ThreadB extends  Thread{
    private Exchanger<String> exchanger;

    public ThreadB(Exchanger<String> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程B获取了线程A的值："+exchanger.exchange("米国人 bb"));
            System.out.println("线程B end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
