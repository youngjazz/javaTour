package designPattern.strategyPattern;

/**
 * Created by leon on 2017/3/3.
 */
public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}
