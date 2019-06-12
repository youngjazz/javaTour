package concurrency.bookcode.BlockingQueue;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by leon on 2017/8/19.
 */
public class PriorityBlockingQueueDemo {
	public static void main(String[] args) {

		//PriorityBlockingQueue中存的对象必须要实现Comparable接口
		PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<Task>();

		Task t1 = new Task(3,"任务3");
		Task t2 = new Task(1,"任务1");
		Task t3 = new Task(2,"任务2");

		queue.put(t1);
		queue.put(t2);
		queue.put(t3);

		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new Runnable() {
			@Override
			public void run() {

			}
		});


		Iterator<Task> iterator = queue.iterator();
		while (iterator.hasNext()){
			Task task = iterator.next();
			System.out.println(task.id+":"+task.getName());
		}
	}
}


class Task implements Comparable<Task>{

	int id;
	String name;

	public Task(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(@NotNull Task task) {
		return this.id > task.id ? 1 : (this.id < task.id ? -1 : 0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}