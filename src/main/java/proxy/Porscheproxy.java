package proxy;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/28 09:58
 */
public class Porscheproxy implements IBuyCar {

	public Customer customer;

	public Porscheproxy(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void buyCar() {
		/**
		 * 优点：可以在不修改直接实现了的前提下，增加购买资格判断
		 * 缺点：目标对象和代理对象实现一样的接口，所以会有很多的代理类，一旦接口增加方法，目标对象和代理对象都需要维护
		 */
		if(customer.cash < 1000000){
			System.out.println("你太穷了！ 去隔壁看看吧 ~");
			return;
		}
		customer.buyCar();
	}

}
