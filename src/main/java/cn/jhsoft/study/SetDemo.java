package cn.jhsoft.study;

import cn.jhsoft.study.bean.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by chen on 2017/8/6.
 */
public class SetDemo {

    public static void main(String[] args) {
//        HashSet hs = new HashSet();
//        hs.add("abc1");
//        hs.add("abc2");
//        hs.add("abc3");
//        hs.add("abc1");
//        System.out.println(hs);
//
//        Iterator it = hs.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//        String s = "ab";
//        System.out.println(s.hashCode());
//        s = "ba";
//        System.out.println(s.hashCode());
//        System.out.println(s.equals("ha"));





//        HashSet hs = new HashSet();
//        hs.add(new Person("hs1", 57));
//        hs.add(new Person("hs2", 27));
//        hs.add(new Person("hs3", 47));
//        hs.add(new Person("hs4", 37));
//        hs.add(new Person("hs2", 27));
//
//        Iterator it = hs.iterator();
//        while (it.hasNext()) {
//            Person p = (Person) it.next();
//            System.out.println(p.getName()+"--"+p.getAge());
//        }


        HashSet hs = new LinkedHashSet();
        hs.add("abc1");
        hs.add("abc2");
        hs.add("abc3");
        hs.add("abc1");
        System.out.println(hs);

        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        String s = "ab";
        System.out.println(s.hashCode());
        s = "ba";
        System.out.println(s.hashCode());
        System.out.println(s.equals("ha"));

    }

}
