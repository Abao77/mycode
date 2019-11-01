package singleton;


/**
 *  懒汉模式： 线程不安全的
 */
public class Singleton4{

    private static Singleton4 instance;

    private Singleton4(){


    }


    public static Singleton4 getInstance (){

        if(instance == null ){
            instance = new Singleton4();
        }

        return instance;
    }



}