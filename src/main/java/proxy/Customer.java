package proxy;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/28 09:55
 */
public class Customer implements IBuyCar {

	public int cash;

	public String name;

	public Customer(int cash, String name) {
		this.cash = cash;
		this.name = name;
	}

	@Override
	public void buyCar() {
		System.out.println(name+"买了一辆车"+cash);
	}
}
