package proxy;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/28 11:12
 */
public class Client {
	public static void main(String[] args) {
		Customer customer = new Customer(10000, "Jack");
		Porscheproxy proxy = new Porscheproxy(customer);
		proxy.buyCar();
	}
}
