package cn.jhsoft.study;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import static java.util.Collections.sort;

/**
 * Created by chen on 2017/8/6.
 * Collections 工具类
 */
public class CollectionsDemo {
    public static void main(String[] args) {


        /*demo1();*/
        int arr[] = {1,2,3,4,5,6,7,8};
        List<int[]> list = Arrays.asList(arr);
        System.out.println(list);

        Integer arrs[] = {1,2,3,4,5,6,7,8};
        List<Integer> lists = Arrays.asList(arrs);
        System.out.println(lists);

        System.out.println(lists.toString());

        List<String> list2 = new ArrayList<String>();
        list2.add("abc3");
        list2.add("abc52");
        list2.add("abc13");
        list2.add("abc14");
        System.out.println(list2);

        // 静态导入，简化了，Collections.sort(list2);
        sort(list2);

        System.out.println(list2);
        String[] arr1 = list2.toArray(new String[list2.size()]);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(list2.toArray()));


        Iterator it = list2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 高级for只用于遍历和迭代，不会对元素进行过多的操作
        for (String s:list2){
            System.out.println(s);
        }

        Map<String, String> map = new HashMap<>();
        map.put("sb1", "sb1111");
        map.put("sb2", "sb1111");
        map.put("sb3", "sb1111");
        map.put("sb4", "sb1111");
        map.put("sb5", "sb1111");

        for (String key:map.keySet()){
            System.out.println(key+"--"+map.get(key));
        }
        for (Map.Entry<String, String> en:map.entrySet()){
            System.out.println(en.getKey()+"--"+en.getValue());
        }

        method1();
        method1("1", "123a", "1234d");

    }

    public static void method1(String... arr){
        System.out.println(Arrays.toString(arr));
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
