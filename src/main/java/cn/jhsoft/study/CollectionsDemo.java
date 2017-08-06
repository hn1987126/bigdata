package cn.jhsoft.study;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by chen on 2017/8/6.
 * Collections 工具类
 */
public class CollectionsDemo {
    public static void main(String[] args) {


        demo1();


    }


    public static void demo1(){
        List<String> list = new ArrayList<String>();
        list.add("ab2");
        list.add("ab1");
        list.add("ab3");
        list.add("ab4");
        list.add("ab5");
        System.out.println(Collections.max(list));

        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // 二分折半查找
        int index = Collections.binarySearch(list, "ab21");
        System.out.println(index);

        // 交换位置
        Collections.swap(list, 2, 3);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.replaceAll(list, "ab4", "nono");
        System.out.println(list);

        //Collections.fill(list, "sb");
        //System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
        

    }
}
