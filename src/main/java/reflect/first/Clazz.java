package reflect.first;

/**
 * Created by zhangyang on 2017/9/6.
 */
public class Clazz {
	private String className;

	private String lever;

	public Clazz(String className, String lever) {
		this.className = className;
		this.lever = lever;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getLever() {
		return lever;
	}

	public void setLever(String lever) {
		this.lever = lever;
	}
}
