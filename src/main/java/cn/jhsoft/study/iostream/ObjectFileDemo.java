package cn.jhsoft.study.iostream;

import cn.jhsoft.study.bean.*;
import cn.jhsoft.study.bean.Person;

import java.io.*;

/**
 * Created by chen on 2017/8/8.
 */
public class ObjectFileDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeFile();
        readFile();
    }

    // 序列化
    private static void writeFile() throws IOException {
        ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream("abc.object"));
        obs.writeObject(new Person("宫涛", 32));
        obs.close();
    }

    // 反序列化
    private static void readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.object"));
        Person p = (Person) ois.readObject();
        System.out.println(p.getName()+"--"+p.getAge());
        ois.close();
    }


}
