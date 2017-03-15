package thingkingInJava.type;

/**
 * Created by leon on 2017/2/25.
 */
interface HashBatteries{}
interface Waterproof{}
interface Shoots{}
class Toy{
    Toy() {}
    Toy(int i){}
}
class FancyToy extends Toy{
    FancyToy() {
        super(1);
    }
}
public class ToyTesy {
    static void printInfo(Class cc){
        System.out.println("Class name:"+cc.getName()
                +" -- is Interface? :"+cc.isInterface());
        System.out.println("Simple name:"+cc.getSimpleName());
        System.out.println("Canonical name:"+cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("type.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            e.printStackTrace();
        }
        printInfo(c);
        for (Class aClass : c.getInterfaces()) {
            printInfo(aClass);
        }
        Object obj = null;
        Class up = c.getSuperclass();

        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        printInfo(obj.getClass());

//        Objects.equals("wq","qw");
    }
}
