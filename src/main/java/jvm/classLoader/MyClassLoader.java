package jvm.classLoader;

import java.io.*;

/**
 * 自定义classLoader
 *
 * @author leon
 * @since 2019-02-21
 */
public class MyClassLoader extends ClassLoader {
    private String path;
    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    //覆盖父类的findClass方法，用于寻找类文件
    @Override
    protected Class findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    //返回类文件的字节流即可；
    //从此我们可以看出，只有有了字节流就可以完成类的加载，这样的字节流可以来自网络，可以是用字节码增强技术ASM生成
    private byte[] loadClassData(String name) {
        name = path + name + ".class";

        //读取某个路径下的类文件
        InputStream in = null;
        ByteArrayOutputStream out = null;

        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }

    //测试
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //给我们的classLoader定义一个名字
        String classLoaderName = "zyClassLoader";
        MyClassLoader myClassLoader = new MyClassLoader("/Users/leon/Desktop/",classLoaderName);

        //因为我们在编写Wali时没有指定package
        Class clazz =  myClassLoader.loadClass("Wali");
        //调用newInstance会触发static代码块
        clazz.newInstance();
    }
}
