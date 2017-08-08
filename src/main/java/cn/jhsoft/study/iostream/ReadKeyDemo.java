package cn.jhsoft.study.iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by chenyi9 on 2017/8/8.
 */
public class ReadKeyDemo {
    public static void main(String[] args) throws IOException {
//        readKey();

        // 字节流转字符流
//        byteToChar();
//        byteToCharOut();

        // 简化代码
//        byteToCharSimple();

//        // 简化代码
//        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("abc.txt")));
//        // 或
//        //BufferedWriter bufw1 = new BufferedWriter(new FileWriter("abc.txt"));
//
//        String line = null;
//        while ((line = bufr.readLine()) != null) {
//            if ("over".equals(line)) {
//                break;
//            }
//            bufw.write(line.toUpperCase());
//            bufw.newLine();
//            // 刷新才会显示出来
//            bufw.flush();
//        }


//        // 简化代码
//        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt")));
//        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String line = null;
//        while ((line = bufr.readLine()) != null) {
//            if ("over".equals(line)) {
//                break;
//            }
//            bufw.write(line.toUpperCase());
//            bufw.newLine();
//            // 刷新才会显示出来
//            bufw.flush();
//        }

        // 简化代码
        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt")));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("abc1.txt")));

        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            // 刷新才会显示出来
            bufw.flush();
        }

    }

    private static void byteToCharSimple() throws IOException {
        // 简化代码
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            // 刷新才会显示出来
            bufw.flush();
        }
    }

    private static void byteToCharOut() throws IOException {
        // 字符转字节
        InputStream is = System.in;
        // 字节流转为字符流的转换器
        InputStreamReader ir = new InputStreamReader(is);
        // 输入缓冲区
        BufferedReader br = new BufferedReader(ir);

        // 输出 字节流，输出到标准控制台。
        OutputStream os = System.out;
        // 这是为了把 最终显示到控制台的 字节流 转字符流。
        // 之前学过的FileWriter 是这个转换流的子类。所以写文件的时候不需要再转换一次，字节直接就以字符的方式写到文件了。
        OutputStreamWriter ow = new OutputStreamWriter(os);
        // 输出缓冲区
        BufferedWriter bw = new BufferedWriter(ow);

        String line = null;
        while ((line = br.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            bw.write(line.toUpperCase());
            bw.newLine();
            // 刷新才会显示出来
            bw.flush();
        }
    }

    private static void byteToChar() throws IOException {
        // 字节流转字符流
        // 字节流
        InputStream is = System.in;
        // 字节流转为字符流的转换器，他是字符流的子类，也是装饰类
        // 如果是中文，占两个字节，所以如果直接用System.in输入中文一个字，会返回两个字符。
        // 而通过字符流输入一个中文汉字，他会去编码表里查表，查到后返回一个字符编码。
        InputStreamReader ir = new InputStreamReader(is);
        // 缓冲区
        BufferedReader br = new BufferedReader(ir);
        String line = null;
        while ((line = br.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            System.out.println(line.toUpperCase());
        }
    }

    private static void readKey() throws IOException {

        // 字节流
        InputStream is = System.in;
        int ch = 0;
        while ((ch = is.read()) != -1) {
            System.out.println(ch + "--" + (char) ch);
        }
        // 这个标准输入输出流不需要关闭，会随着系统关而关，它只有一个，关了就没了。
        //is.close();

//        int a = 10;
//        if (a == (char)'\n'){
//            System.out.println(a);
//        }
    }
}
