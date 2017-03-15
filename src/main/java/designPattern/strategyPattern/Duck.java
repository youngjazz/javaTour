package designPattern.strategyPattern;

/**
 * 抽象类--所有鸭子子类都继承
 * Created by leon on 2017/3/3.
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly(); //委托给行为类
    }

    public void performQuack(){
        quackBehavior.quack(); //委托给行为类
    }

    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }

    /**
     * 动态设定行为,我们可以随时调用这两个方法改变鸭子的行为
     * @param flyBehavior
     */
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
