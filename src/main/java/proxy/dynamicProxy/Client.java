package proxy.dynamicProxy;

import proxy.Customer;
import proxy.IBuyCar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2017/11/28 11:15
 */
public class Client {
	public static void main(String[] args) {
		Customer customer = new Customer(10000,"Jack");
		DynamicProxy handler = new DynamicProxy(customer);

		IBuyCar buyCar = (IBuyCar) Proxy.newProxyInstance(customer.getClass().getClassLoader(),customer.getClass().getInterfaces(),handler);
		buyCar.buyCar();
	}
}

class DynamicProxy implements InvocationHandler{

	private Customer customer;

	public DynamicProxy(Customer customer) {
		this.customer = customer;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(customer.cash < 1000000){
			System.out.println("你太穷了，建议去别家看看");
			return  null;
		}

		Object invoke = method.invoke(customer, args);
		return invoke;
	}
}
