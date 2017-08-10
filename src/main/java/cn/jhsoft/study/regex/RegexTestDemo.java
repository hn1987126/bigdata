package cn.jhsoft.study.regex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenyi9 on 2017/8/10.
 */
public class RegexTestDemo {

    public static void main(String[] args) throws Exception {

        // 治口吃
//        test1();

        // 对ip地址排序
//        test2();

        // 对邮箱检验
//        test3();

        // 网页爬虫
        test4();
    }

    /**
     * 爬虫爬取邮箱地址。
     */
    private static void test4() throws Exception {

        List<String> list = new ArrayList<>();

        // 1.读取源文件
        //BufferedReader bufr = new BufferedReader(new FileReader("email.html"));
        // 上面是获取本地资源，接下来获取网页资源
        URL url = new URL("http://www.cnitpm.com/pm1/46030.html");
        // url.openStream()获取的是InputStream，要操作文本，需要转化。
        BufferedReader bufr = new BufferedReader(new InputStreamReader(url.openStream()));

        // 2.对读取的数据进行规则的匹配。从中获取符合规则的数据
        String regex = "\\w+@[a-zA-Z0-9]+(\\.\\w+)+";
        Pattern pattern = Pattern.compile(regex);

        String line = null;
        while ((line = bufr.readLine()) != null) {
            // 通过正则对象获取匹配器对象
            Matcher m = pattern.matcher(line);
            // 循环找 m.find() ，找到了就取出找到的结果 m.group()
            while (m.find()){
                list.add(m.group());
            }
        }

        // 3.将符合规则的数据存储到集合中
        for (String str : list){
            System.out.println(str);
        }

        bufr.close();
    }

    /**
     * 检验邮箱
     */
    private static void test3() {
        String email = "abc@qq.com.cn";
        String regex = "\\w+@[a-zA-Z0-9]+(\\.\\w+)+";
        boolean b = email.matches(regex);
        System.out.println(b);
    }

    /**
     * ip排序
     * 192.168.10.34  127.0.0.1   3.3.3.3    105.70.11.55
     * 规则，第一位 数字越小越排前面
     */
    private static void test2() {

        String str = "192.168.10.34  127.0.0.1   3.3.3.3    105.70.11.55";

        // 1.为了让ip可以按照字符串顺序比较，只要让ip的每一段位数相同。
        // 所以，补零，按照每一位所需做多0进行补充，每一段都加两个0
        str = str.replaceAll("(\\d+)", "00$1");
        // 然后每一段保留数字3位
        str = str.replaceAll("(\\d{0,2})(\\d{3})", "$2");
        // 再用TreeSet排序，它存储的时候就有顺序
        TreeSet<String> ts = new TreeSet<>();

        // 2.将ip地址切出，按空格出现1次或多次
        String[] ips = str.split(" +");
        for (String ip : ips) {
            ts.add(ip);
            System.out.println(ip);
        }
        for (String ip : ts){
            // 0*后面跟的数字，取那数字，就适用于505这种，没有0后面就是数字，要得到那数字
            // 如果是 005，那就得到5，适合解决那种中间是 0 的正常情况，只要去掉以0开头的情况
            System.out.println(ip.replaceAll("0*(\\d+)", "$1"));
        }
    }

    private static void test1() {
        String str = "我我...我...我我我要...要要要要...要要要要..学学学...编编程";

        // 1.将字符串中的.去掉。用替换
        str = str.replaceAll("\\.", "");

        // 2.替换叠词
        str = str.replaceAll("(.)\\1+", "$1");

        System.out.println(str);
    }

}




























