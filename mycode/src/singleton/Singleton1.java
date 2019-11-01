package singleton;


/**
 *  饿汉式：线程安全的
 *
 *  -构造器私有化
 *  -自行创建，用静态变量保存
 *  -对外提供这个实例
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }


}





