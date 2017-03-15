package thingkingInJava;

/**
 * Created by leon on 2017/2/19.
 */
public class TestRegularExeception {
    public static void main(String[] args) {
        if(args.length > 2){
            System.out.println("Usage: \njava TestRegularException "+"characterSequence regularException");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return "TestRegularExeception{}";
    }
}
