package concurrency.bookcode.ProducerAndConsumer2;


/**
 * DESCRIPTION：提交的任务或数据
 *
 * @author zhangyang 2018/4/24 09:07
 */
public final class PCData {
	
	private final int value;
	
	public PCData(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "PCData{" +
			"value=" + value +
			'}';
	}
}
