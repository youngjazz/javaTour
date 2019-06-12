package concurrency.bookcode.ThreadPool.userDefindThreadPool;

/**
 * Created by zhangyang on 2017/9/9.
 */
public class Mytask implements Runnable{

	private int id;

	private String name;

	public Mytask(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(id+" run:"+name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
