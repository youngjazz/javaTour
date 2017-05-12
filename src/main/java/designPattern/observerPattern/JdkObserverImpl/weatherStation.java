package designPattern.observerPattern.JdkObserverImpl;

/**
 * 一个测试程序
 * Created by leon on 2017/3/9.
 */
public class weatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(80,90,30.4f);
        weatherData.setMeasurements(82,70,29.3f);
        weatherData.setMeasurements(78,90,29.3f);
    }


}
