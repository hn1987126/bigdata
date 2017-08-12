package cn.jhsoft.study.obj;

/**
 * Created by chen on 2017/8/12.
 */
class MyException extends Exception{

    MyException(String message){
        super(message);
    }

}

public class ErrorDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        try {
            test2(arr, 5);
            throw new Exception("我是在try里再throw的");
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage()+e);

        }
    }

    public static void test2(int[] arr, int num) throws Exception {
        getLenth(arr, num);
    }

    public static void getLenth(int[] arr, int num) throws Exception {
        if(num >= arr.length){
            //throw new RuntimeException("越界了");
            //throw new ArrayIndexOutOfBoundsException();
            throw new MyException("异常了");
        }

        System.out.println(arr[num]);
    }

}
