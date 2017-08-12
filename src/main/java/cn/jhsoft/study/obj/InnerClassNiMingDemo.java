package cn.jhsoft.study.obj;

/**
 * Created by chen on 2017/8/11.
 *
 * 匿名内部类
 *
 */

abstract class DemoN{
    abstract void show();
}

interface MyInter{
    void show1();
    void show2();
}

class OuterN{

    {
        System.out.println("我是OuterN的构造代码块");
    }

    int num = 4;
    public void method(){

        // 匿名内部类继承自抽象
        new DemoN(){
            @Override
            void show() {
                System.out.println("ni ming show"+num);
            }
        }.show();

        // 匿名内部类实现接口
        MyInter mi = new MyInter(){
            @Override
            public void show1() {
                System.out.println("show1"+num);
            }
            @Override
            public void show2() {
                System.out.println("show2"+num);
            }
        };
        mi.show1();
        mi.show2();



    }

    // 内部类
    public class InterImpl implements MyInter{

        @Override
        public void show1() {

        }

        @Override
        public void show2() {

        }
    }

    /// 常用情景
    public void hihi(MyInter mi){
        mi.show1();
    }


}

public class InnerClassNiMingDemo {

    {
        System.out.println("我是InnerClassNiMingDemo的构造代码块");
    }

    public static void main(String[] args) {
        new OuterN().method();

        // 匿名类作为参数传递
        new OuterN().hihi(new MyInter() {
            @Override
            public void show1() {
                System.out.println("我是作为参数的show1");
            }

            @Override
            public void show2() {

            }
        });

        // 创建一个本类的匿名子类，并有子类特有的show方法
        new InnerClassNiMingDemo(){
          void show(){
              System.out.println("sha ye bugan");
          }
        }.show();
    }
}
