package cn.jhsoft.study;

import cn.jhsoft.study.bean.Student;
import cn.jhsoft.study.sort.ComparatorByName;
import scala.collection.mutable.HashTable;

import java.util.*;

/**
 * Created by chen on 2017/8/6.
 */
public class MapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
//        method(map);
//        method2(map);

        HashMap<Student, String> map1 = new HashMap<>();
        method3(map1);

        // 有序的
        TreeMap<Student, String> map2 = new TreeMap<>(new ComparatorByName());
        method4(map2);

    }

    public static void method(Map<Integer, String> map) {
        map.put(1, "abc1");
        map.put(2, "abc2");
        map.put(3, "abc3");
        map.put(4, "abc4");
        map.put(4, "abc5");

        System.out.println("get:"+map.get(1));
        System.out.println("remove:"+map.remove(6));
        System.out.println(map);

        System.out.println(map.containsKey(4));
    }

    public static void method2(Map<Integer, String> map1) {
        map1.put(1, "abc1");
        map1.put(2, "abc2");
        map1.put(3, "abc3");
        map1.put(4, "abc4");
        map1.put(4, "abc5");

        // 取出map的所有元素：
        // 方法1：  keySet 可以理解成 丈夫的合集
        // 通过keySet方法获取 map中所有的 key 得到set集合,通过set的迭代器获取到每一个键，再对每一个键通过map集合的get方法获取其对应的值即可
        Set keySet = map1.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            System.out.println(map1.get(it.next()));
        }

        // 方法2：entrySet 可以理解成结婚证书的合集
        // 通过Map转换成Set就可以迭代，entrySet方法将键和值的映射关系作为对象存储到Set集合中，而这个映射关系的类型就是Map.Entry类型(结婚证)
        Set<Map.Entry<Integer, String>> entries = map1.entrySet();
        Iterator<Map.Entry<Integer, String>> it1 = entries.iterator();
        while (it1.hasNext()) {
            Map.Entry<Integer, String> en = it1.next();
            System.out.println(en.getKey()+1+"--"+en.getValue());
        }

        // 只要map里元素的值，不要key，vlues返回Collection，为啥不返回set呢？因为值是不唯一的，而key是唯一的，所以只能返回Collection
        System.out.println(map1.values());



    }

    public static void method3(Map<Student, String> map) {
        map.put(new Student("abc31", 29), "北京");
        map.put(new Student("abc33", 25), "上海");
        map.put(new Student("abc33", 25), "上海1");
        map.put(new Student("abc3432", 31), "安庆");

        Set<Student> set = map.keySet();
        Iterator<Student> it = set.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            System.out.println(student.getName()+"--"+student.getAge()+"--"+map.get(student));
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }


    // 有序的
    public static void method4(Map<Student, String> map) {
        map.put(new Student("abc31", 29), "北京");
        map.put(new Student("abc33", 25), "上海");
        map.put(new Student("abc3432", 31), "安庆");

        Set<Map.Entry<Student, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Student, String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Student, String> en = it.next();
            System.out.println(en.getKey().getName()+"--"+en.getKey().getAge()+"--"+en.getValue());
        }



    }

}
