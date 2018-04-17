package concurrent.MasterWorker;

import sun.jvm.hotspot.runtime.Threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by zhangyang on 2017/9/3.
 */
public class Master {
	//首先要有一个盛装任务的集合
	private ConcurrentLinkedDeque<Task> workQueue = new ConcurrentLinkedDeque<Task>();

	//使用hashMap盛装所有的worker对象
	private HashMap<Integer, Thread> workers = new HashMap<Integer, Thread>();

	//使用一个容器盛装每一个worker并行执行的结果集
	private ConcurrentHashMap<Integer, Object> resultMap = new ConcurrentHashMap<Integer, Object>();

	//构造方法
	public Master(Worker worker, int workCount){

		//每一个worker对象都必须有master的引用, workQueue用于任务的领取, resultMap用于任务的提交
		worker.setWorkQueue(this.workQueue);
		worker.setResultMap(this.resultMap);

		for (int i = 0; i < workCount; i++) {
			//key表示一个worker的名字, value表示线程执行对象
			workers.put(i, new Thread(worker));
		}

	}

	//提交方法
	public void submit(Task task){
		this.workQueue.add(task);
	}

	//需要一个执行方法(启动应用程序 让所有的worker工作)
	public void excute(){
		for (Map.Entry<Integer, Thread> threadEntry : workers.entrySet()) {
			threadEntry.getValue().start();
		}
	}

	public boolean isCompleted(){
		for (Map.Entry<Integer, Thread> threadEntry : workers.entrySet()) {
			if(threadEntry.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}

		return true;
	}

	public long getResult() {
		long ret = 0;
		System.out.println(isCompleted());
		if(isCompleted()){
			for (Map.Entry<Integer, Object> objectEntry : resultMap.entrySet()) {

				ret +=(Integer) objectEntry.getValue();
			}
		}

		return ret;
	}
}
