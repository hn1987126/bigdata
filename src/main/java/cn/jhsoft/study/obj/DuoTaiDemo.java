package cn.jhsoft.study.obj;

import clojure.lang.IFn;

/**
 * Created by chen on 2017/8/11.
 */

abstract class Animal{
    abstract void eat();

    static void method(){
        System.out.println("fu method");
    }
}

class Dog extends Animal{
    void eat(){
        System.out.println("吃骨头");
    }
    void lookHome(){
        System.out.println("look home");
    }

    static void method(){
        System.out.println("zi method");
    }
}

class Cat extends Animal{
    void eat(){
        System.out.println("吃鱼");
    }
    void catchMouse(){
        System.out.println("捉老鼠");
    }
}


public class DuoTaiDemo {
    public static void main(String[] args) {
//        method(new Cat());
        method(new Dog());

//        method(new Cat());

//        Animal a = new Cat();// 多态，向上转型
//        a.eat();  // Animal里有eat方法，Cat对他覆盖了。所以这里会调Cat的eat方法。
//        Cat c = (Cat)a;// 向下转型
//        c.catchMouse(); // 可以调子类Cat的特有方法

//        Cat c2 = new Cat();
//        Animal a2 = (Animal)c2;
//        a2.eat();
    }

    public static void method(Animal a){
        a.eat();
        a.method();

        // instanceof 对象类型的判断，用于判断对象的具体类型，只能用于引用数据类型的判断。后面可以是接口名也可以是类名。所有子类的对象都 instanceof 父类。
        // 通常在向下转型前进行判断一下，提高程序的健壮性。
        if (a instanceof Dog) {
            Dog d = (Dog) a;// 向下转型
            d.lookHome();
        }
    }
}
