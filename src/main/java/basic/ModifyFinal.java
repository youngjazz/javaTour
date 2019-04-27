package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon
 * @date 2019-04-08
 */
public class ModifyFinal {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(list);

        add(list);
        System.out.println(list);

        asign(list);
        System.out.println(list);
    }


    private static void add(final List<String> list){
        list.add("new new new");
    }

    private static void asign(final List<String> list){
//        list = new ArrayList<>(); 报错
    }
}
