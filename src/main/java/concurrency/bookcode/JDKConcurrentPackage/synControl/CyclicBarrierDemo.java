package concurrency.bookcode.JDKConcurrentPackage.synControl;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * DESCRIPTION：循环栅栏
 *
 * @author zhangyang 2018/3/12 23:44
 */
public class CyclicBarrierDemo {
	
	public static void main(String[] args) {
		final int N = 100;
		Thread[] allSoldier = new Thread[N];
		boolean flag = false;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(N,new BarrierRun(flag,N));
		
		System.out.println("```````````````集合```````````````");
		for (int i = 0; i < N; i++) {
			System.out.println("士兵"+i+"报道");
			allSoldier[i] = new Thread(new Soldier("士兵"+i,cyclicBarrier));
			allSoldier[i].start();
			allSoldier[0].interrupt();
		}
	}
	
	public static class Soldier implements Runnable{
		private String soldier;
		private final CyclicBarrier cyclicBarrier;
		
		public Soldier(String soldier, CyclicBarrier cyclicBarrier) {
			this.soldier = soldier;
			this.cyclicBarrier = cyclicBarrier;
		}
		
		void doWork(){
			try {
				Thread.sleep(Math.abs(new Random().nextInt()%10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(soldier+":任务完成");
		}
		
		@Override
		public void run() {
			//等待所有士兵到齐
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class BarrierRun implements Runnable{
		boolean flag;
		int N;
		
		public BarrierRun(boolean flag, int n) {
			this.flag = flag;
			N = n;
		}
		
		@Override
		public void run() {
			if(flag){
				System.out.println("司令[士兵"+N+"个，任务完成]");
			}else{
				System.out.println("司令[士兵"+N+"个，集合完毕]");
				flag = true;
			}
		}
	}
}
