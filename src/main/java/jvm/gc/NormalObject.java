package jvm.gc;

/**
 * @author leon
 * @date 2019-03-01
 */
public class NormalObject {
   public String name;

    public NormalObject(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing obj "+name);
    }
}
