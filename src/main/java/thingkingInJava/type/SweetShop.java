package thingkingInJava.type;



/**
 * Created by leon on 2017/2/25.
 */
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("Inside main...");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("type.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}

class Candy{
    static {
        System.out.println("Loading Candy");
    }
}

class Gum{
    static {
        System.out.println("loading Gum");
    }
}

class Cookie{
    static{
        System.out.println("Loading Cookie");
    }
}