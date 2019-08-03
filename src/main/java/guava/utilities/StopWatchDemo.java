package guava.utilities;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author 张洋
 * @date: 2019-06-13 19:35
 */
@Slf4j
public class StopWatchDemo {
    public static void main(String[] args) throws InterruptedException {
        process("123123131");
    }

    private static void process(String orderNo) throws InterruptedException {
        log.info("start process the order, "+orderNo);
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.MILLISECONDS.sleep(100);
        log.info("the order[{}] process successful, and elapsed [{}] ms",orderNo, stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
    }
}
