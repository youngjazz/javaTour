package designPattern.observerPattern;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/5 18:08
 */
public interface Subject {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}
