package singleton;


/**
 *  懒汉式： 线程安全的
 *
 *  volatile: -可见性      -不保证原子性      -禁止指令重排
 */
public class Singleton5 {

    private static volatile Singleton5 instance = null;

    private Singleton5(){

    }


    public static Singleton5 getInstance(){

        if(instance == null){

            synchronized(Singleton5.class){

                if(instance == null){

                    instance = new Singleton5();

                }
            }

        }

        return instance;

    }



}
