package concurrency.bookcode.BlockingQueue;

/**
 * Created by leon on 2017/8/20.
 */
public class FultureDemo {

	public static void main(String[] args) {
		FultureClient fc = new FultureClient();
		Data data = fc.request("请求发送参数");
		System.out.println("请求发送成功");
		System.out.println("做其他事情");

		String result = data.getRequest();
		System.out.println(result);
	}
}

class FultureClient{
	public Data request(final String queryStr){
		final FultureData fultureData = new FultureData();
		new Thread(new Runnable() {
			@Override
			public void run() {
				RealData realData = new RealData(queryStr);
				fultureData.setRealData(realData);

			}
		}).start();

		return fultureData;
	}
}

class FultureData implements Data{
	private boolean isReady = false;
	private RealData realData;

	public synchronized void setRealData(RealData realData) {
		if(isReady){
			return;
		}

		this.realData = realData;
		isReady = true;
		notify();
	}

	@Override
	public String getRequest() {
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return this.realData.getRequest();
	}
}

class RealData implements Data{
	private String result;

	public RealData(String queryStr){
		System.out.println("根据"+queryStr+"进行查询，这是一个很耗时的过程");
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("计算完毕");
		result = "jisuanjieguo";

	}
	@Override
	public String getRequest() {
		return result;
	}
}
interface Data{
	String getRequest();
}
