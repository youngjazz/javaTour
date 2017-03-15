package designPattern.observerPattern;

/**
 * Created by leon on 2017/3/9.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
