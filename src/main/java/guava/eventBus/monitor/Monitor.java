package guava.eventBus.monitor;

/**
 * @author 张洋
 * @date: 2019-08-03 11:37
 */
public interface Monitor {
    void startMonitor() throws Exception;
    void stopMonitor() throws Exception;
}
