package cn.jhsoft.study;

import java.util.*;

/**
 * Created by chen on 2017/8/6.
 */
public class ListDemo {

    public static void main(String[] args) {
//        List list = new ArrayList();
//        //show(list);
//
//        list.add("abc1");
//        list.add("abc2");
//        list.add("abc3");
//        list.add("abc4");
//        list.add("abc5");
//        list.add("abc6");
//
//        // 列表迭代器
//        ListIterator lit = list.listIterator();
//        while (lit.hasNext()) {
//
//            Object obj = lit.next();
//            if (obj.equals("abc2")){
//                lit.set("abc222");
//            }
//            if (obj.equals("abc6")){
//                lit.remove();
//            }
//        }
//        System.out.println(list);
//
//        // 往前遍历
//        while (lit.hasPrevious()) {
//            System.out.println(lit.previous());
//        }


        // 链表
        LinkedList link = new LinkedList();
        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");
        link.addFirst("abc4");

        Iterator it = link.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(link.removeFirst());
        System.out.println(link);
        System.out.println(link.remove());
        System.out.println(link);

        while (!link.isEmpty()) {
            System.out.println(link.getFirst());
            link.removeFirst();
        }
        System.out.println(link);



    }

    private static void show(List list){
        // 添加元素
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        list.add("abc5");
        list.add("abc6");
        System.out.println(list);

        // 插入元素
        list.add(1, "sb");
        System.out.println(list);

        // 删除元素
        System.out.println(list.remove("abc5"));
        System.out.println(list.remove(1));
        System.out.println(list);

        // 修改元素
        System.out.println(list.set(2, "abc33"));
        System.out.println(list);

        // 获取元素
        System.out.println(list.get(2));

        System.out.println(list.indexOf("abc33"));
        System.out.println(list.subList(1, 3));

        for (Iterator it = list.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

        // list特有的取出所有元素的方式之一
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
