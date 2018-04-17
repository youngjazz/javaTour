package concurrent.ExecutorService;

import com.alibaba.fastjson.JSON;
import org.apache.http.impl.client.FutureRequestExecutionMetrics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by leon on 2017/6/12.
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newScheduledThreadPool(10);

        //execute(Runnable)
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous tasks");
            }
        });


        //submit(Runnable)
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous tasks1");
            }
        });

        System.out.println(future.get());//return null if the task has finished correctly

        //submit(Callable)
        Future future2 = executorService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("Asynchronous tasks2");
                return "Callable Result";
            }
        });
        System.out.println(future2.get());

        executorService.shutdown();
        System.out.println("---------------------------------------------------");


        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 1";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return  "task 2";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 3";
            }
        });

        List<Future<String>> list = executorService1.invokeAll(callables);
        for (Future<String> stringFuture : list) {
            System.out.println("furture.get="+stringFuture.get());
        }
        String result = executorService1.invokeAny(callables);

        System.out.println("result = "+ JSON.toJSONString(result));

        executorService1.shutdown();
    }
}
