package cn.jhsoft.study;

import cn.jhsoft.study.bean.Person;
import cn.jhsoft.study.bean.Student;
import cn.jhsoft.study.sort.ComparatorByName;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by chen on 2017/8/6.
 */
public class TreeSetDemo {

    public static void main(String[] args) {

        //getTreeSet();

        //compareable();

        TreeSet ts = new TreeSet(new ComparatorByName());
        ts.add(new Student("p1", 25));
        ts.add(new Student("p2", 22));
        ts.add(new Student("p3", 27));
        ts.add(new Student("p4", 25));
        ts.add(new Student("p5", 29));

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            Student p = (Student)it.next();
            System.out.println(p.getName()+"--"+p.getAge());
        }

    }

    private static void compareable() {
        TreeSet ts = new TreeSet();
        ts.add(new Student("p1", 25));
        ts.add(new Student("p2", 22));
        ts.add(new Student("p3", 27));
        ts.add(new Student("p4", 25));
        ts.add(new Student("p5", 29));

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            Student p = (Student)it.next();
            System.out.println(p.getName()+"--"+p.getAge());
        }
    }

    private static void getTreeSet() {
        TreeSet ts = new TreeSet();
        ts.add("aa2");
        ts.add("zaa1");
        ts.add("aa4");
        ts.add("aa3");
        ts.add("aa5");

        System.out.println(ts);
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}



