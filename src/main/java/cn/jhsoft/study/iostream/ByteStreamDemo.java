package cn.jhsoft.study.iostream;

import java.io.*;

/**
 * Created by chen on 2017/8/7.
 */
public class ByteStreamDemo {

    public static void main(String[] args) throws IOException {
//        demo_write();
//        demo_read();
        demo_write_buffer();
        demo_read_buffer();
    }

    private static void demo_write() throws IOException {

        // 创建字节输出流对象，用于操作文件
        FileOutputStream fs = new FileOutputStream("bytestream.txt");
        // 写数据，直接写入到了目的地中，所以不需要flush也就是不需要缓冲。缓冲区Buffer才会用到flush方法。
        fs.write("abc".getBytes());
        // 需要完成资源关闭
        fs.close();

    }

    private static void demo_read() throws IOException {

        // 创建读取流对象，和指定文件关联。
        FileInputStream fs = new FileInputStream("bytestream.txt");
        // 读取的两种方式，建议用上面这种。
        // 这叫自定义缓冲区   一次读取一个缓冲区数组大小的数组
        byte[] buf = new byte[1024];
        int len;
        while ((len = fs.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }

        // 输出流的新读取方式
        // 获取文件的字节数(英文只占一个字节，中文占两个)  fs.available()
//        byte[] buf = new byte[fs.available()];
//        fs.read(buf);
//        System.out.println(new String(buf));

        fs.close();

    }

    private static void demo_write_buffer() throws IOException {

        // 创建字节输出流对象，用于操作文件
        FileOutputStream fs = new FileOutputStream("bytestream2.txt");
        BufferedOutputStream bs = new BufferedOutputStream(fs);
        // 写数据，直接写入到了目的地中，所以不需要flush也就是不需要缓冲。缓冲区Buffer才会用到flush方法。
        bs.write("abc".getBytes());
        // 缓冲区需要flush
        bs.flush();
        // 关闭缓冲区
        bs.close();

    }

    private static void demo_read_buffer() throws IOException {

        // 创建读取流对象，和指定文件关联。
        FileInputStream fs = new FileInputStream("bytestream2.txt");
        BufferedInputStream bs = new BufferedInputStream(fs);
        int ch;
        while ((ch = bs.read()) != -1) {
            System.out.print((char)ch);
        }
        bs.close();

    }

}
