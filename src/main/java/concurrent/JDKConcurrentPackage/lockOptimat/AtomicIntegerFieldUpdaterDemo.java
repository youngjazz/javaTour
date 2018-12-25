package concurrent.JDKConcurrentPackage.lockOptimat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * DESCRIPTION：让普通变量享受原子操作
 *
 * @author zhangyang 2018/4/19 09:29
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static class Canditate {
        int          id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Canditate> scoreUpdater = AtomicIntegerFieldUpdater
            .newUpdater(Canditate.class, "score");
    
    //检查Updater是否工作正确
	public static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Canditate stu = new Canditate();
        Thread[] t = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            t[i] = new Thread() {
                @Override
                public void run() {
                    if (Math.random() > 0.4) {
						scoreUpdater.incrementAndGet(stu);
						allScore.incrementAndGet();
                    }
                }
            };
	        t[i].start();
        }
	
	    for (int i = 0; i < 10000; i++) {
		    t[i].join();
	    }
	
	    System.out.println("score="+stu.score);
	    System.out.println("allscore="+allScore);
    }
}
