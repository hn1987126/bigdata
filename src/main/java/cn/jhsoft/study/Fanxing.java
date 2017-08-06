package cn.jhsoft.study;

import cn.jhsoft.study.bean.Person;
import cn.jhsoft.study.bean.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chen on 2017/8/6.
 */
public class Fanxing {

    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("ab1", 22));
        list1.add(new Person("ab2", 22));
        list1.add(new Person("ab3", 22));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("bb1", 2));
        list2.add(new Student("bb2", 2));

//        printCollection(list1);
//        printCollection(list2);
        printCollection2(list1);
        printCollection2(list2);

    }


    // 上限
    public static void printCollection(Collection<? extends Person> col) {
        Iterator<? extends Person> it = col.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            System.out.println(p.getName()+"--"+p.getAge());
        }
    }

    // 下限
    public static void printCollection2(Collection<? super Student> col) {
        Iterator<? super Student> it = col.iterator();
        while (it.hasNext()) {
//            Student student = it.next();
//            System.out.println(student.getName()+"--"+student.getAge());
            System.out.println(it.next());
        }
    }

}
