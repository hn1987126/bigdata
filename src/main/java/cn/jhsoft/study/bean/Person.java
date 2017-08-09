package cn.jhsoft.study.bean;

import java.io.Serializable;

/**
 * Created by chen on 2017/8/6.
 */
public class Person implements Serializable {

    private transient String name;
    private static int age;

    public Person(){

    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        System.out.println(this.toString()+"hashCode----"+super.hashCode());
        //return name.hashCode() + age*37;
        //return 100;
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.print("equals laile--");
        //return super.equals(obj);
        System.out.print(obj.toString()+"---this:");
        System.out.println(this.toString());
        Person p = (Person) obj;
        return p.name.equals(this.name) && p.age == this.age;
        //return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
