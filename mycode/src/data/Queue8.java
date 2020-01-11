package data;


/**
 * 解决八皇后问题
 *
 * 回溯算法（递归）
 *
 */
public class Queue8 {

    //共有多少个皇后
    static int max = 8;

    static int count = 0;

    //定义一个数组
    static int[] arr = new int[max];

    //遍历
    private  static void print(){

        count++;

        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    //检查第n个皇后的位置是否和之前的皇后位置冲突
    private static boolean check(int n){

        for (int i = 0; i < n; i++) {

            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])){

                return false;
            }
        }
        return true;
    }


    //放置第n个皇后
    public static void go(int n){

        if(n == max){

            print();
            return ;
        }

        for (int i = 0; i < max; i++) {
            arr[n] = i;

            if(check(n)){
                go(n+1);
            }
        }
    }


    public static void main(String[] args) {

        go(0);
        System.out.println("解法共有："+count);
    }



}
