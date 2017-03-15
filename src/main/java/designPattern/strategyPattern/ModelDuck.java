package designPattern.strategyPattern;

/**
 * 新的鸭子类型，玩具鸭
 * Created by leon on 2017/3/3.
 */
public class ModelDuck extends Duck {
    public void display() {
        System.out.println("I'm a model duck!");
    }

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
}
