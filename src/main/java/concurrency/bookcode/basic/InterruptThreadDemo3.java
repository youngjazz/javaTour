package concurrency.bookcode.basic;

/**
 * DESCRIPTION：TODO
 * InterruptExption不是运行时异常，所以必须捕获并且处理它，当线程在sleep()休眠时，如果被中断，这个异常会产生。
 * 此时它会清除中断状态.所以需要在捕获异常是再次设置中断状态
 *
 * @author zhangyang 2017/11/19 23:12
 */
public class InterruptThreadDemo3 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 =new Thread(){
			@Override
			public void run() {

				while(true){
					//System.out.println("线程interrupt ?:"+Thread.currentThread().isInterrupted());
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interrupted");
						break;
					}

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						System.out.println("Interrupt when sleep");
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}


			}
		};

		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}

}
