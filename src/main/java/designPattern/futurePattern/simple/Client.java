package designPattern.futurePattern.simple;

/**
 * DESCRIPTION：Client实现了获取FutureData，并开启构造RealData线程，并快速返回FutrueData，这个Futrue中并没有真实数据
 *
 * @author zhangyang 2018/4/27 10:05
 */
public class Client {
	public Data request(final String queryStr){
		final FutureData futureData = new FutureData();
		new Thread(){
			@Override
			public void run() {
				RealData realData = new RealData(queryStr);
				futureData.setRealData(realData);
			}
		}.start();
		return futureData;
	}
}
