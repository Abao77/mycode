package singleton;


/**
 *  懒汉式： 静态内部类  线程安全的
 */
public class Singleton6 {

    private Singleton6(){

    }

    public static Singleton6 getInstance(){

        return Inner.INSTANCE;
    }

    private static class Inner{

        private static final Singleton6 INSTANCE = new Singleton6();

    }


}
