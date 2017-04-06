package concurrency.Chapter3;

import com.sun.tools.internal.jxc.gen.config.NGCCEventSource;

import java.awt.*;
import java.util.EventListener;

/**
 * 使用工厂方法来防止this引用在构造过程中逸出
 * Created by leon on 2017/4/5.
 */
public class SafeListener {

    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event e){
               // doSomeThing(e);

            }
        };
    }

    public static SafeListener newInstance(NGCCEventSource eventSource){
        SafeListener safeListener = new SafeListener();

        return safeListener;
    }
}
