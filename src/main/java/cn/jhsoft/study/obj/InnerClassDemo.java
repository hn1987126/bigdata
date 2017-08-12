package cn.jhsoft.study.obj;

/**
 * Created by chen on 2017/8/11.
 */
public class InnerClassDemo {

    public static void main(String[] args) {
        Outer o = new Outer();
        //o.main();
        o.show();

//        Outer.Inner inner = new Outer().new Inner();
//        inner.show();
    }

}

class Outer {
    int age = 10;
    public void main() {
        Inner i = new Inner();
        i.show();
    }
    class Inner{
        public void show(){
            // 可以自由访问 外面的成员变量
            System.out.println("Inner show"+age);
        }
    }

    public void show(){
        class ShowInner{
            public void show(){
                System.out.println("Inner show"+age);
            }
        }
        ShowInner si = new ShowInner();
        si.show();
    }
}
