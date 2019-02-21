package basic;

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
        int i =1;
        int j = 5;
        i++;
        ++j;
        System.out.println(i++);
        System.out.println(j++);
    }
}
