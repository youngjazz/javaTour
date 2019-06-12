package concurrency.bookcode.ConcurrentNavigateMap;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by leon on 2017/6/12.
 */
public class Main {
    public static void main(String[] args) {
        ConcurrentNavigableMap map = new ConcurrentSkipListMap();
        map.put("1","value1");
        map.put("2","value2");
        map.put("3","value3");
        map.put("4","value4");

        System.out.println(map.headMap("2"));
        System.out.println(map.subMap("2","3"));
        System.out.println(map.tailMap("3"));
    }
}
