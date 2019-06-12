package concurrency.bookcode.basic;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/20 22:35
 */
public class SimpleWaitAndNotify {
    final static Object obj = new Object();

    public static class T1 extends Thread{
		@Override
		public void run() {
			synchronized (obj){
				System.out.println(System.currentTimeMillis()+":T1 start!");
				try {
					System.out.println(System.currentTimeMillis()+":T1 wait for obj!");
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis()+":T1 end!");

			}
		}
	}

	public static class T2 extends Thread{
		@Override
		public void run() {
			synchronized (obj){
				System.out.println(System.currentTimeMillis()+":T2 start! notify one thread");
				obj.notify(); //t2通知t1后，t1并没有立即继续执行，而是要等到t2释放obj的锁，并重新成功获得锁后，才继续执行。
				System.out.println(System.currentTimeMillis()+":T2 end!");
				try {
					Thread.sleep(2000);
					//wait和sleep都能让线程等待若干时间，wait可以被唤醒；同时只是wait会释放目标对象的锁，而sleep不会释放任何资源
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t2 = new T2();

		t1.start();
		t2.start();
	}
}
