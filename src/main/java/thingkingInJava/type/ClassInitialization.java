package thingkingInJava.type;

import java.util.Random;

/**
 * Created by leon on 2017/3/5.
 */
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 =ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3{
    static int staticNonFinal = 74;
    static{
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        //Does not trigger initalization
        System.out.println(Initable.staticFinal);
        //Does not trigger initalization
        System.out.println(Initable.staticFinal2);
        //Does not trigger initalization
        System.out.println(Initable2.staticNonFinal);
        try {
            Class initable3 = Class.forName("thingkingInJava.type.Initable3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}


