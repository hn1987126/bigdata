package cn.jhsoft.study.obj;

/**
 * Created by chenyi9 on 2017/8/11.
 */
class A{
    protected void show2(){
        System.out.println("fu show run");
    }
    A(){
        System.out.println("fu run");
    }
    A(int x){
        System.out.println("fu run"+x);
    }
}
class B extends A{
    public void show2(){
        System.out.println("zi show run");
    }
    public B(){
        System.out.println("zi run");
    }
    B(int x){
        this();
        System.out.println("zi run"+x);
    }
}



public class ExtendsDemo {

    public static void main(String[] args) {

        new B(1);

//        B b = new B();
//        b.show2();

//        Phone p = new NewPhone();
//        p.show();
//        p.call();
    }

}

class Phone{
    void show(){
        System.out.println("number");
    }
    void call(){}
}

class NewPhone extends Phone{
    void show(){
        super.show();
        System.out.println("name");
        System.out.println("pic");
    }

    void show1(){
        System.out.println("show1");
    }
}
