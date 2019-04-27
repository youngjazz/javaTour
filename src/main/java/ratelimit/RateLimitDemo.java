package ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * RateLimiter是guava提供的基于令牌桶算法的实现类，可以非常简单的完成限流特技，并且根据系统的实际情况来调整生成token的速率。
 *
 * 通常可应用于抢购限流防止冲垮系统；限制某接口、服务单位时间内的访问量，譬如一些第三方服务会对用户访问量进行限制；
 * 限制网速，单位时间内只允许上传下载多少字节等
 * @author leon
 * @date 2019-03-07
 */
public class RateLimitDemo {
    public static void main(String[] args) {

        //create 表示一秒钟最多多产生少个令牌
        RateLimiter rateLimiter = RateLimiter.create(5);

        List<Runnable> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            taskList.add(new UserReqeust(i));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Runnable task : taskList) {
            System.out.println("等待时间："+rateLimiter.acquire());
            executorService.submit(task);
        }
    }

    private static class UserReqeust implements Runnable{
        private long id;

        public UserReqeust(long id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(id);
        }
    }
}
