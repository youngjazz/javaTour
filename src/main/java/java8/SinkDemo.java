package java8;

import java.util.Arrays;
import java.util.List;

/**
 * 理解Sink，它定义了每个Stream之间的关系协议
 * @author 张洋
 * @date: 2019-09-20 15:57
 */
public class SinkDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张洋","张小三二","yuanyuan");
        String nameMaxLength = names.stream()
                .filter(name -> name.startsWith("张"))
                .mapToInt(String::length)
                .max()
                .toString();

        System.out.println(nameMaxLength);
    }
}
