package cn.jhsoft.study.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Created by chenyi9 on 2017/8/8.
 */
public class PropertyDemo {

    public static void main(String[] args) throws IOException {

//        method();

//        store();

//        load();

        // 读配置文件，修改里面的数据，并保存
//        edit();

    }

    private static void edit() throws IOException {
        // 读配置文件，修改里面的数据，并保存
        File file = new File("abc.properties");
        if (!file.exists()){
            file.createNewFile();
        }
        FileReader fr = new FileReader(file);
        Properties prop = new Properties();
        prop.load(fr);
        prop.setProperty("abc2", "100");

        FileWriter fw = new FileWriter(file);
        prop.store(fw, "love");
        fr.close();
        fw.close();
    }

    private static void load() throws IOException {
        // 集合中的数据来自一个文件。
        // 注意，必须要保证该文件中的数据是键值对。
        // 需要用到读取流来完成
        //FileInputStream fs = new FileInputStream("abc.txt");
        FileReader fs = new FileReader("abc.txt");
        Properties prop = new Properties();
        prop.load(fs);
        prop.list(System.out);
    }

    private static void store() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("abc1", "25");
        prop.setProperty("abc14", "26");
        prop.setProperty("abc13", "27");
        prop.setProperty("abc2", "28");

//        // 用于调试用
//        prop.list(System.out);

        // 配置文件是存在于内存中，内存一旦释放就全没了，想把它里面的内容保存到硬盘上，这就是持久化。
        // 想要将这些集合中的字符串键值信息持久化存储到文件中，需要关联输出流
        FileOutputStream fs = new FileOutputStream("abc.txt");
        //prop.store(fs, "name+age");
        prop.store(new FileWriter("abc.txt"), "name+age");
    }

    private static void method() {
        Properties prop = new Properties();
        prop.setProperty("ght", "35");
        System.out.println(prop.getProperty("ght"));
        System.out.println(prop.getProperty("ght", "25"));

        Set<String> names = prop.stringPropertyNames();
        for (String str : names) {
            System.out.println(str + "-" + prop.getProperty(str));
        }

        Set<String> set = prop.stringPropertyNames();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String k = it.next();
            System.out.println(k+"---"+prop.getProperty(k));
        }
    }

}
