package basic.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 从list中删除元素
 *
 * @author leon
 * @date 2019-04-01
 */
public class ListRemoveElement {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("aaa");
        list.add("mvc");

//        deleteByFori(list);
//        deleteFor(list);
        deleteByIterator(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    //有什么问题
    private static void deleteByFori(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("a")) {
                list.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    private static void deleteFor(List<String> list) {
        for (String s : list) {
            if (s.contains("a")) {
                list.remove(s);
            }
        }
    }

    private static void deleteByIterator(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.contains("a")) {
                iterator.remove();
            }
        }
    }
}
