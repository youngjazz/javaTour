package designPattern.decoratotPattern;

import designPattern.decoratotPattern.impl.HouseBlend;
import designPattern.decoratotPattern.impl.Milk;
import designPattern.decoratotPattern.impl.Mocha;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/6 17:46
 */
public class StartBuzzCoffee {
	public static void main(String[] args) {
		Beverage beverage = new HouseBlend();
		beverage = new Mocha(beverage);
		beverage = new Milk(beverage);
		System.out.println(beverage.cost());
	}
}
