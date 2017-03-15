package thingkingInJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by leon on 2017/2/19.
 */
public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+")
                .matcher("Everything is full of the linner's wings");

        while(m.find()){
            System.out.print(m.group()+" ");
        }
        System.out.println();
        int i = 0;
        while(m.find(i)){
            System.out.print(m.group()+" ");
            i++;
        }


    }
}
