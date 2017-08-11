package cn.jhsoft.study.obj;

/**
 * Created by chenyi9 on 2017/8/11.
 */

interface Demo{
    public static final int NUM = 4;

    void work();
    void eat();
    void show();
}
interface A4{
    int show(int a);
}
interface B4 extends A4,Demo{
    int show(int a, int b);
}

class DemoImpl implements Demo,A4{

    @Override
    public void work() {
        int a = NUM * 2;
        System.out.println(a);
    }

    @Override
    public void eat() {

    }

    @Override
    public void show() {

    }

    @Override
    public int show(int a) {
        return 1;
    }
}

class B4Impl implements B4{

    @Override
    public void work() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void show() {

    }

    @Override
    public int show(int a) {
        return 0;
    }

    @Override
    public int show(int a, int b) {
        return 0;
    }
}


public class InterfaceDemo {
    public static void main(String[] args) {
        DemoImpl di = new DemoImpl();
        di.work();
        System.out.println(Demo.NUM);
        System.out.println(DemoImpl.NUM);
        System.out.println(di.NUM);
    }
}
