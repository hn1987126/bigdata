package cn.jhsoft.study.iostream;

import scala.reflect.New;

/**
 * Created by chen on 2017/8/7.
 */
public class PersonDemo {

    public static void main(String[] args) {
        Person p = new Person();
        NewPerson np = new NewPerson(p);
        np.eat();
    }

}

class Person{
    void eat(){
        System.out.println("吃饭");
    }
}

class NewPerson{
    Person p;
    NewPerson(Person p) {
        this.p = p;
    }

    void eat(){
        System.out.println("甜点");
        p.eat();
        System.out.println("水果");
    }
}