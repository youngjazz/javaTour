package designPattern.observerPattern;

/**
 * 目前状况布告板
 * 实现了Observer接口，所以可以获取WeatherData对象中的数据
 * 实现了DisplayElement接口，我们的API规定所有的布告板都要实现该接口
 * Created by leon on 2017/3/9.
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private Subject wealtherData;

    public CurrentConditionDisplay(Subject subject) {
        this.wealtherData = subject;
        subject.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current condition: "+temperature+"F degree and "+humidity+"% humidity");
    }
}
