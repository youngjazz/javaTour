package concurrent.basic;

import sun.jvm.hotspot.debugger.cdbg.AccessControl;

/**
 * DESCRIPTION：synchronized 有多种用法，整理如下
 * 对给定对象加锁，在进入同步代码块之前要获得指定对象的锁
 * 对当前实例加锁，在进入同步代码块之前要获得当前实例的锁
 * 对当前类加锁，在进入同步代码块之前要获得当前类的锁
 * 或将其用在静态方法，在进入同步方法时获取的是当前类的锁
 *
 * 注意这里线程的创建方式，使用Runnable接口创建两个线程，并且两个线程指向同一个Runnable接口实例（instance对象）
 * 这样才能保证两个线程在工作时，能够关注到同一个对象锁上去，从而保证线程安全。
 *
 * @author zhangyang 2017/12/3 22:01
 */
public class AccountingVol implements Runnable{

	static AccountingVol instance = new AccountingVol();
	static volatile int i = 0;

	synchronized void increase(){
//		synchronized (instance){
//			i++;
//		}
		i++;
	}

	@Override
	public void run() {
		for(int j = 0; j < 1000000; j++){
			increase();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);

		//如果使用的是下面方法，就犯了严重的错误，应为t1,t2都会尝试对各自实例加锁，因此获得是两个不同的锁
		//但只要保证increase 是static同样可以得到正确的答案，因为static获取的当前类的锁
//		Thread t1 = new Thread(new AccountingVol());
//		Thread t2 = new Thread(new AccountingVol());

		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
	}
}
