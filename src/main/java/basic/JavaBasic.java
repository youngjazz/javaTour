package basic;

import java.util.Date;

/**
 * 演示java命令
 *
 * cd 到Source root这里是src/main/java
 * javac basic/JavaBasic.java
 * java basic.JavaBasic #result: 2, 6
 * javap -c basic.JavaBasic
 *
 * @author leon
 * @since 2019-02-20
 */
public class JavaBasic {
    public static void main(String[] args) {
        int i = 1;
        int j = 5;
        i++;
        ++j;
        System.out.println(i++);
        System.out.println(j++);


        float a = 3.2f;
        float b = 2.4f;
        System.out.println(b - a);

        Date date = new Date();
        System.out.println(date.getTime());



    }
}
