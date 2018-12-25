package designPattern.futurePattern.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/28 08:36
 */
public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<String> futureTask = new FutureTask<>(new RealData("a"));
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(futureTask);
		System.out.println("请求完毕");
		
		//do orther things
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(futureTask.isDone());
		System.out.println("data:"+futureTask.get());
	}
}
