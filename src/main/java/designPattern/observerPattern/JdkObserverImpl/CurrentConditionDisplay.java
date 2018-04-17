package designPattern.observerPattern.JdkObserverImpl;

import java.util.Observable;
import java.util.Observer;

/**
 * 重做CurrentConditionDisplay
 * jdk实现
 * Created by yang.zhang on 2017/3/16.
 */
public class CurrentConditionDisplay implements Observer {

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display() {
        System.out.println("Current conditions:"+temperature+"F degree and "+humidity+"% humidity");
    }

    public void update(Observable o, Object obj) {
        if(obj instanceof WeatherData){
            WeatherData weatherData = (WeatherData) obj;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
