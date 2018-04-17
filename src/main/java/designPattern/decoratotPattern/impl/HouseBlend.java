package designPattern.decoratotPattern.impl;

import designPattern.decoratotPattern.Beverage;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/6 17:42
 */
public class HouseBlend implements Beverage {
	@Override
	public double cost() {
		return 1;
	}
}
