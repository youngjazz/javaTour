package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * description: Future
 *
 * @author 张洋
 * @date: 2019-05-08 19:12
 * @modified By:
 */
public class FutureDemo {

    public Future<Double> getPriceAsync(String productName) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                //模拟计算任务用时
                Thread.sleep(1000);
                Double price = 12.0D;
                //完成future操作并设置商品价格
//                simulateError();
                future.complete(price);

            } catch (InterruptedException e) {
                //抛出失败异常
                future.completeExceptionally(e);
            }
        }).start();

        return future;
    }

    public Future<Double> getPriceAsync2(String productName) {
        //生产者方法会交由ForkJoinPool执行,当然可以指定我们自己的executor
        return CompletableFuture.supplyAsync(() -> 12.0);
    }

    private void simulateError() {
        throw new RuntimeException("Some Error");
    }
}
