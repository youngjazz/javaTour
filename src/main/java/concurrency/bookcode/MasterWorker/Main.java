package concurrency.bookcode.MasterWorker;

import java.util.Random;

/**
 * Created by zhangyang on 2017/9/3.
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("可用线程:"+Runtime.getRuntime().availableProcessors());
		Master master = new Master(new Worker(),10);

		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			Task task = new Task();
			task.setId(i);
			task.setName("任务"+i);
			task.setPrice(random.nextInt(1000));
			master.submit(task);
		}

		master.excute();
		long starter = System.currentTimeMillis();
		while (true){
			if(master.isCompleted()){
				long result = master.getResult();
				System.out.println("最终计算结果:"+result);
				long ender = System.currentTimeMillis();
				System.out.println("计算总耗时"+ (ender-starter)+"ms");
				break;
			}
		}
	}
}
