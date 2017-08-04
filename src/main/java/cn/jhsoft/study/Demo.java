package cn.jhsoft.study;

/**
 * Created by chenyi9 on 2017/8/4.
 * 匿名内部类
 */



interface A {
    void funcA(String a);
    void funcB(int a);
}

public class Demo{

    public static void main(String[] args) {
        A a = new A(){
            @Override
            public void funcA(String a) {
                System.out.println(a);
            }

            @Override
            public void funcB(int a) {
                System.out.println(a+"");
            }
        };
        a.funcA("sb");
        a.funcB(1);

        new A(){
            @Override
            public void funcB(int c) {

            }

            @Override
            public void funcA(String a) {
                System.out.println(a);
            }
        }.funcA("sbb");



        try{
            funcC();
        }catch (Exception e){
            System.out.println("main");
        }
        System.out.println("mainfunc");


        // 这个方法里抛出 运行时异常，那他之后的就都不会执行。
        funcD();
        System.out.println("funcD End");

    }

    public static void funcC() {
        try {
            throw new Exception();
        }
        catch (Exception e){
            System.out.println("func");
        }
    }

    public static void funcD() {
        throw new ARE("输入非法");
        // thorw new IllegalArgumentException("参数错误")
        // thorw new RuntimeException("输入非法");
    }


}

class ARE extends RuntimeException{
    public ARE(String message) {
        super(message);
    }
}
