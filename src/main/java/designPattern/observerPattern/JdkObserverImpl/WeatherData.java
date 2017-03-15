package designPattern.observerPattern.JdkObserverImpl;

import designPattern.observerPattern.Observer;
import designPattern.observerPattern.Subject;

import java.util.ArrayList;
import java.util.Observable;

/**
 * java内置实现
 * Created by leon on 2017/3/9.
 */
public class WeatherData extends Observable {
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i>= 0){
            observers.remove(i);
        }
    }

    /**
     * 当气象站得到新的观测值是，我们通知观察者
     */
    public void measurementChanged(){
        notifyObservers();
    }

    /**
     * 因为每个观察者都实现了update方法，所以我们知道如何通知他们
     */
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    /**
     * 用于模拟数据来源
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.humidity = humidity;
        this.temperature = temperature;
        this.pressure = pressure;
        measurementChanged();
    }



    //WeatherData的其他方法

}
