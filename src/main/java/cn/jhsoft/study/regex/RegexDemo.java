package cn.jhsoft.study.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenyi9 on 2017/8/10.
 */
public class RegexDemo {

    public static void main(String[] args) {

//        demo();
        // 匹配
//        regex_demo1();
        // 切割
//        regex_demo2();
        // 替换
//        regex_demo3();
        // 获取
        regex_demo4();

    }

    // 获取
    private static void regex_demo4() {

        // 要得到三个字母组成的单词
        String str = "da jia hao,ming tian bu fang jia!";
        // Pattern是正则表达式对象      java.util.regex.Pattern
        // Matcher是匹配器对象   java.util.regex.Matcher
        /**
         获取
            将正则规则进行对象的封装
         Pattern p = Pattern.compile("\w+@[a-zA-Z0-9]+(\.\w+)+");
         // 通过正则对象的matcher方法 字符串相关联。获取要对字符串操作的匹配器对象Matcher
         Matcher m = p.matcher("aaaaab");
         // 通过Matcher匹配器对象的方法 对字符串进行操作
         boolean b = m.matchers();    m.find();   m.group()   等
         */

        String regex = "\\b[a-z]{3}\\b";

        // 1.将正则封装成对象
        Pattern p = Pattern.compile(regex);
        // 2.通过正则对象获取匹配器对象
        Matcher m = p.matcher(str);
        // 3.使用Matcher对象的方法 对字符串进行操作
        // 既然要获取三个字母组成的单词，那就查找 find()
        System.out.println(str);
        while(m.find()){
            System.out.println(m.group());  // 获取匹配的子序列
            System.out.println(m.start()+":"+m.end());
        }

    }

    // 替换
    private static void regex_demo3() {

        String str2 = "zhangsan####ab1&&&ab2";
        // 叠词操作，把多个重复的词，替换为一个 感叹号。与切割时的用法一样。
        str2 = str2.replaceAll("(.)\\1+", "!");
        System.out.println(str2);

        // 把匹配到的 重复的字母替换为一个它自己，如4个#替换为一个#, 多个&替换为1个&
        // 第二个参数里使用第一个参数里的正则的结果，$1,$2等。
        str2 = str2.replaceAll("(.)\\1+", "$1");
        System.out.println(str2);

        // 替换手机号中间的*
        String str = "15800001111";
        str = str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(str);

    }

    /**
     * 切割
     */
    private static void regex_demo2() {

        String str = "zhangsan   ab1        ab2";
        // 用一个或多个空格来 切割
        String[] names = str.split(" +");
        for (String name:names){
            System.out.println(name);
        }

        String str1 = "zhangsan.ab1.ab2";
        // 用一个或多个空格来 切割
        String[] names1 = str1.split("\\.");
        for (String name:names1){
            System.out.println(name);
        }

        String str2 = "zhangsan####ab1&&&ab2";
        // 叠字,按重复的字符来分隔 括号括起来的是组(.)，正则会把他编号为1,要取他，需要\\1
        // 如果没有括号，那就没有组，\\1 就没有意义
        // 复杂组 如 ((A)(B(C))) 从左括号看，去数组，第一个左括号是第1组，第二个左括号是第2组，类推
        // 组0 代表整个表达式。
        String[] names2 = str2.split("(.)\\1+");
        for (String name:names2){
            System.out.println(name);
        }


    }

    /**
     * 匹配
     */
    private static void regex_demo1() {

        // 匹配手机号
        String mobile = "13512231122";
        String regex = "1[34587]\\d{9}";
        boolean b = mobile.matches(regex);
        System.out.println(b);

    }

    private static void demo() {
        String qq = "12345678";
        String regex = "[1-9][0-9]{4,14}";
        boolean b = qq.matches(regex);
        System.out.println(b);
    }

}
