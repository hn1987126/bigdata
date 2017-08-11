package cn.jhsoft.study.obj;

/**
 * Created by chenyi9 on 2017/8/11.
 * Final 最终
 */
final class C{

}

class A1{
    private void method(){
        // 调用底层系统资源，不想要子类重载它
        System.out.println("fu");
    }

    final void aa(){

    }
}
class B1 extends A1{
    void method(){
        System.out.println("zi");
    }
}

public class FinalDemo {

    public static void main(String[] args) {
        B1 b1 = new B1();
        b1.method();
    }

}
