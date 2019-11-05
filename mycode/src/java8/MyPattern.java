package java8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPattern {

    /**
     *  要求：
     *      ATG之后 以TAG|TAA|TGA结束 通过正则表达式完成
     *
     * @param str 输入的基因组
     */
    public static void myMethod(String str){

        String pattern = "ATG(.*?)((TAG)|(TAA)|(TGA))";

        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(str);

        if(m.find()==true){

            m.reset();

            while(m.find()){

                System.out.println(m.group(1));
            }

        }else{

            System.out.println("No gene is found!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a genome string ：");
        String str = input.next();

        myMethod(str);

        //myMethod("TTATGTTTTAAGGATGGGGCGTTAGTT");

    }



}
