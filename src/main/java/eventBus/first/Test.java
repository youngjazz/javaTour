package eventBus.first;

/**
 *
 * DESCRIPTION：测试
 *
 * @author zhangyang 2018/8/17 14:03
 */
public class Test {
	public static void main(String[] args) {
		DataObserver1 observer1 = new DataObserver1();
		DataObserver2 observer2 = new DataObserver2();

		EventBusCenter.register(observer1);
		EventBusCenter.register(observer2);

		System.out.println("============== start ==================");

		EventBusCenter.post("Post starting method");
		EventBusCenter.post(123);

		System.out.println("============== after unregister ==============");

		EventBusCenter.unRegister(observer2);
		EventBusCenter.post("Post starting method");
		EventBusCenter.post(123);

		System.out.println("================== end ===============");

	}
}
