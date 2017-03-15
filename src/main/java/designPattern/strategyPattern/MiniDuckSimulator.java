package designPattern.strategyPattern;

/**
 * 测试类
 * Created by leon on 2017/3/3.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallarDuck();
        mallard.performFly(); //会调用继承来的performFly方法，进而委托给该对象的的flyBehavior对象
        mallard.performQuack();
        System.out.println("---------------------------");
        //改变测试类
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
    }
}
