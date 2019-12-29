package guava.eventBus.monitor;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * @author 张洋
 * @date: 2019-08-03 11:38
 */
@Slf4j
public class DirectoryMonitor implements Monitor{

    //监控开关
    private volatile boolean start = false;

    private final EventBus eventBus;

    private final Path path;

    private WatchService watchService;

    public DirectoryMonitor(EventBus eventBus, final String path) {
        this(eventBus, path, "");
    }

    public DirectoryMonitor(EventBus eventBus, final String path, final String... morePath) {
        this.eventBus = eventBus;
        this.path = Paths.get(path, morePath);
    }



    @Override
    public void startMonitor() throws Exception {
        this.watchService = FileSystems.getDefault().newWatchService();
        this.path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_DELETE);
        log.info("The directory [{}] is monitoring...", path);
        this.start = true;
        while (start){
            WatchKey watchKey = watchService.take();
            watchKey.pollEvents().forEach(event->{
                WatchEvent.Kind<?> kind = event.kind();
            });
        }
    }

    @Override
    public void stopMonitor() throws Exception {

        start = false;
    }
}
