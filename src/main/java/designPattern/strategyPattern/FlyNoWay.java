package designPattern.strategyPattern;

/**
 * Created by leon on 2017/3/3.
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly");
    }
}
