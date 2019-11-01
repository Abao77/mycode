package java8;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口 @FunctionalInterface
 *
 *
 *1.消费型接口的抽象方法特点：有形参，但是返回值类型是void
 *2.供给型接口的抽象方法特点：无参，但是无返回值
 *3.函数(功能)型接口的抽象方法特点：既有参数又有返回值
 *4.断言型接口的抽象方法特点：有参，但是返回值类型是boolean结果。
 */
public class FunctionDemo {

    public static void main(String[] args) {

        //消费型接口
        Consumer<String> consumer = (t)->{
            System.out.println(t);
        };
        consumer.accept("Hello Consumer~");

        //供给型接口
        Supplier<String> supplier = ()->{
            return UUID.randomUUID().toString().substring(0,8);
        };
        System.out.println(supplier.get());

        //功能型接口
        Function<String,Integer> function = (s)->{
            return s.length();
        };
        System.out.println(function.apply("abcd"));

        //断言型接口
        Predicate<String> predicate = (s)->{
            return s.startsWith("a");
        };
        System.out.println(predicate.test("asfsdfsfd"));


    }





}
