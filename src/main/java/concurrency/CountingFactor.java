package concurrency;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by leon on 2017/3/27.
 */
public class CountingFactor {
    private final AtomicLong count = new AtomicLong();

    public long getCount() {
        return count.get();
    }

    public void service(){
        //do something
        count.incrementAndGet();
        //do something
    }
}
