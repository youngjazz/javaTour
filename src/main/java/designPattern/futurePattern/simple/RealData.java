package designPattern.futurePattern.simple;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/4/27 09:59
 */
public class RealData implements Data {
	protected final String result;
	
	public RealData(String para) {
		//RealData的构造可能很慢，这里使用sleep模拟
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		result = sb.toString();
	}
	
	@Override
	public String getResult() {
		return result;
	}
}
