package algotithm;

import org.apache.poi.ss.formula.functions.T;

/**
 * DESCRIPTION：跳表
 *
 * @author zhangyang 2018/3/7 13:53
 */
public class SkipList<T> {


}

class Node{
	T value;
	int level;
	Node right;
	Node down;
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public Node getDown() {
		return down;
	}
	
	public void setDown(Node down) {
		this.down = down;
	}
}