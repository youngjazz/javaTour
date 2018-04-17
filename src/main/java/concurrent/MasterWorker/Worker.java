package concurrent.MasterWorker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by zhangyang on 2017/9/3.
 */
public class Worker implements Runnable{

	private ConcurrentLinkedDeque<Task> workQueue;
	private ConcurrentHashMap<Integer, Object> resultMap;

	@Override
	public void run() {
		while(true){
			Task input = this.workQueue.poll();
			if(input == null) break;

			Object output = handle(input);
			this.resultMap.put(input.getId(),input.getPrice());
		}
	}

	private Object handle(Task input) {
		Object output = null;

		try {
			//模拟计算耗时
			System.out.println("计算中");
			Thread.sleep(50);
			output = (int)input.getPrice();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

	public void setWorkQueue(ConcurrentLinkedDeque<Task> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(ConcurrentHashMap<Integer, Object> resultMap) {
		this.resultMap = resultMap;
	}

}
