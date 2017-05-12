package annotation;

import java.util.Arrays;

/**
 * Created by yang.zhang on 2017/5/8.
 */
@Table(tableName = "fruit")
public class Apple {
    @FruitName("Apple")
    private String name;
    @FruitColor(color = FruitColor.Color.Red)
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void display(){
        System.out.println(getName()+" "+getColor() );
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.display();
        System.out.println(Arrays.toString(apple.getClass().getAnnotations()));
    }
}
