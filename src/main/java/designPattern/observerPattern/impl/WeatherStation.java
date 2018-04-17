package designPattern.observerPattern.impl;

/**
 * DESCRIPTION：TODO
 *
 * @author zhangyang 2018/3/6 13:58
 */
public class WeatherStation {
	public static void main(String[] args) throws InterruptedException {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		
		weatherData.setMeasurement(0,0,0);
		Thread.sleep(1000);
		weatherData.setMeasurement(1,1,1);
	}
}
