package guava.collections;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张洋
 * @date: 2019-10-16 16:53
 */
public class ListsDemo {
    public static void main(String[] args) {
        List<Integer> origin = Arrays.asList(1, 2, 3, 4, 5);
        for (List<Integer> partition : Lists.partition(origin, 3)) {
            System.out.println(partition);
        }
    }
}
