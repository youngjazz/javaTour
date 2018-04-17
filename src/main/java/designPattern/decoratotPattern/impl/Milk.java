package designPattern.decoratotPattern.impl;

import designPattern.decoratotPattern.Beverage;
import designPattern.decoratotPattern.CondimentDecorator;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/6 17:45
 */
public class Milk extends CondimentDecorator {
	
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		return 1+beverage.cost();
	}
}
