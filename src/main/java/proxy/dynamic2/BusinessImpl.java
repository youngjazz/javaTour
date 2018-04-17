package proxy.dynamic2;

/**
 * DESCRIPTION：具体实现类，被代理的对象
 *
 * @author zhangyang 2018/2/28 16:27
 */
public class BusinessImpl implements BusinessInterface {
	@Override
	public void doSomeWork() {
		System.out.println("进行业务逻辑处理。。。");
	}
}
