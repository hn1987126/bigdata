package cn.jhsoft.study;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by chen on 2017/8/6.
 */
public class CollectionDemo {

    public static void main(String[] args) {
        show(new ArrayList());
    }

    public static void show(Collection coll){
        coll.add("1");
        coll.add("2");

        System.out.println(coll);
    }

}
