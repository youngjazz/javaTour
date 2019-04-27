package jvm.reflect;

/**
 *
 * @author leon
 * @since 2019-02-21
 */
public class Robot {
    private String name;

    public void sayHi(String helloSentence) {
        System.out.println(helloSentence + " " + name);
    }

    private String throwHello(String tag) {
        return "Hello " + tag;
    }

    static {
        System.out.println("Hello Robot!");
    }
}
