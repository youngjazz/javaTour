package designPattern.observerPattern.JdkObserverImpl;

import java.util.Observable;

/**
 * java内置实现
 * Created by leon on 2017/3/9.
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;


    /**
     * 当气象站得到新的观测值是，我们通知观察者
     */
    public void measurementChanged(){
        setChanged();
        notifyObservers();
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

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
