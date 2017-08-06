package cn.jhsoft.study;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by chen on 2017/8/6.
 */
public class CollectionDemo {

    public static void main(String[] args) {
        //show(new ArrayList());
        // show(new ArrayList(), new ArrayList());

        Collection coll = new ArrayList();
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");

//        Iterator it = coll.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        for(Iterator it = coll.iterator(); it.hasNext();){
            System.out.println(it.next());
        }

    }

    public static void show(Collection coll){
        coll.add("1");
        coll.add("2");
        coll.add("sbsbsb");

        coll.remove("2");  // 集合的remove方法是会改变集合长度

        System.out.println(coll);
    }

    public static void show(Collection coll, Collection coll2){
        coll.add("1");
        coll.add("2");
        coll.add("sbsbsb");
        coll.add("33");
        coll.add("444");

        coll2.add("33");
        coll2.add("444");

        System.out.println(coll);
        System.out.println(coll2);


        // coll2 的元素添加到coll中
        coll.addAll(coll2);
        System.out.println(coll);

        // containsAll
        boolean b = coll.containsAll(coll2);
        System.out.println(b);

        // retainAll功能刚与removeAll相反，把两集合中不同元素 从调用retainAll方法的集合中删除
        boolean b1 = coll.retainAll(coll2);
        System.out.println(coll);


        // 将两个集合中的相同元素 从调用removeAll方法的集合中删除
        coll.removeAll(coll2);
        System.out.println(coll);


    }


}
