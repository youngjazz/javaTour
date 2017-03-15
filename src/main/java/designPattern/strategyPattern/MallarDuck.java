package designPattern.strategyPattern;

/**
 * Created by leon on 2017/3/3.
 */
public class MallarDuck extends Duck {

    /**
     * 同样的行为，在构造器里实例化为具体的现实类
     */
    public MallarDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck!");
    }
}
