package designPattern.futurePattern.simple;

/**
 * DESCRIPTION：FutureData 是RealData的包装
 *
 * @author zhangyang 2018/4/27 10:07
 */
public class FutureData implements Data {
	protected RealData realData = null;
	protected boolean isReady = false;
	
	public synchronized void setRealData(RealData realData){
		if(isReady){
			return;
		}
		this.realData = realData;
		this.isReady = true;
		notifyAll();
	}
	
	@Override
	public synchronized String getResult() {
		while (!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
			
			}
			
		}
		
		return realData.result;
	}
}
