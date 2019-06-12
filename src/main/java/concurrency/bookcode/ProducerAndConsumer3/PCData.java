package concurrency.bookcode.ProducerAndConsumer3;


/**
 * DESCRIPTION：提交的任务或数据
 *
 * @author zhangyang 2018/4/24 09:07
 */
public final class PCData {
	
	private long value;
	
	public long get() {
		return value;
	}
	
	public void set(long value) {
		this.value = value;
	}
}
