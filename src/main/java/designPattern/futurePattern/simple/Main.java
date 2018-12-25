package designPattern.futurePattern.simple;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/27 10:17
 */
public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕");
		
		try {
			//模拟其他业务逻辑耗时
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//使用真实数据
		System.out.println("数据 = "+ data.getResult());
	}
}
