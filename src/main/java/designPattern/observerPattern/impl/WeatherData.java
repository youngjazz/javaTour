package designPattern.observerPattern.impl;

import designPattern.observerPattern.Observer;
import designPattern.observerPattern.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/5 18:16
 */
public class WeatherData implements Subject {
    private List<Observer> observers ;
    
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(Observer o) {
		observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if(index >0){
		    observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature,humidity,pressure);
        }
    }
    
    public void setMeasurement(float temperature,float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    
        notifyObservers();
    }
}
