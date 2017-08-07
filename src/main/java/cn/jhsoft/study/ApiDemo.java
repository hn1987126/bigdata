package cn.jhsoft.study;


import java.util.Properties;
import java.util.Set;

/**
 * Created by chenyi9 on 2017/8/7.
 */
public class ApiDemo {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        //System.out.println(System.getProperties());

        System.out.println("Hello"+LINE_SEPARATOR+"world");



        // Properties集合，继承自HashTable，继承自Map双列集合
        Properties pro = System.getProperties();
        // 获取里面所有的key
        Set<String> keySet = pro.stringPropertyNames();
        for (String str : keySet) {
            // 根据key找value
            System.out.println(str+"："+pro.getProperty(str));
        }
    }
}
