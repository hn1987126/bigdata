package cn.jhsoft.study.iostream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class DateStreamDemo {

    public static void main(String[] args) throws IOException {
//        writeData();
        readData();
    }

    private static void readData() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("utf.txt"));
        String str = dis.readUTF();
        System.out.println(str);
        dis.close();
    }

    private static void writeData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("utf.txt"));
        // utf修改版的，存进去时会自动加标头，别的人解不开，只能用他自己提供的方法去解开
        dos.writeUTF("你好");
        dos.close();
    }

}
