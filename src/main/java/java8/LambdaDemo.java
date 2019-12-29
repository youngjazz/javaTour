package java8;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.DoubleStream;

/**
 * description:
 *
 * @date: 2019-04-22 20:31
 * @modified By:
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {System.out.println(12);};
        runnable.run();

        //有类型推断
        Comparator<Apple> c = (a, b) -> a.getWight().compareTo(b.getWight());
        int compare = c.compare(new Apple(1), new Apple(2));
        System.out.println(compare);

        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(4));
        appleList.add(new Apple(2));
        appleList.add(new Apple(3));
        appleList.add(new Apple(7));


        for (int i = 0; i < 5; i++) {
            System.out.println(appleList.stream().filter(item->item.getWight()>2).findAny().get());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(appleList.parallelStream().filter(item->item.getWight()>2).findAny().get());
        }

        for (int i = 0; i < 5; i++) {
            DoubleStream.of(6.2, 7.3, 8.4, 9.5).findFirst().ifPresent(System.out::println);
        }
    }


}
@Data
class Apple{
    public Apple(Integer wight) {
        this.wight = wight;
    }

    private Integer wight;
    private String color;


}