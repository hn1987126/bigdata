package cn.jhsoft.study.iostream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by chenyi9 on 2017/8/7.
 */
public class FileWriterReaderDemo {

    private static final String LINE_SEPER = System.getProperty("line.separator");

    public static void main(String[] args) {
//        write();
//        reader();
//        copy();

//        trycopy();



    }

    private static void trycopy() {
        FileReader fr = null;
        FileWriter fw = null;
        try{

            fr = new FileReader("c:\\sys001.log");
            // 写数据
            fw = new FileWriter("c:\\sys001_copy.log");
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                fw.write(buf, 0, len);
            }

        }catch (IOException e){

        }finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭文件失败");
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭文件失败");
                }
            }
        }
    }

    private static void copy() throws IOException {
        // 练习：复制c盘的文本文件到d盘
        // 思路就是先读取出源文件，再写入到目标文件。既然是操作文本文件，使用字符流
        // 读数据
        FileReader fr = new FileReader("c:\\sys001.log");
        // 写数据
        FileWriter fw = new FileWriter("c:\\sys001_copy.log");
        char[] buf = new char[1024];
        int len = 0;
        while ((len = fr.read(buf)) != -1) {
            fw.write(buf, 0, len);
        }
        // 关闭流
        fw.close();
        fr.close();
    }

    private static void reader() throws IOException {
        /**
         创建读取字符数据的流对象。
         在创建读取流对象时，必须要明确被读取的文件。一定要确定该文件是存在的
         用一个读取流 关联一个已存在的文件。
         读文件的过程：本质上是一次读一个字节，只不过用char[] buf = new char[1024]，
         是把一次读一个字节，先放在这个数组里，等这个数组满1024，或者读到 -1 代表读完了。
         再把这个char[] 字节数组转为 字符串。完成读取过程。
         */
        FileReader fr = new FileReader("demo1.txt");
        // 使用read(char[])读取文本文件数据，一般这数字就是1024，因为存储时就是按这大小来存的。
        char[] buf = new char[1024];
        // 将读到的字符存储到数组中，返回读取到的字符数量。
        int len = 0;
        while ((len = fr.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }

        fr.close();
    }

    private static void write() throws IOException {
        /*
        创建一个可以往文件中写入字符数据的字符输出流对象
        既然是往一个文件中写入文字数据，那么在创建对象时，就必须明确该文件(用于存储数据的目的地)
        如果文件不存在，则会自动创建。
        如果文件存在，则会被覆盖，也就是先删掉再创建。
        构造函数里可以指定第二个参数，是否追加写入，默认是覆盖。
        * */
        FileWriter fw = new FileWriter("demo1.txt", true);
        // 调用 write 方法 ，数据会被临时存储，写入到了临时存储缓冲区中。
        fw.write("sf"+LINE_SEPER+"sbbb");
        // 进行刷新，将数据从缓冲区 写到目的地中。
        //fw.flush();
        // 关闭流关闭资源，关闭之前，会自动调用flush()
        fw.close();
    }

}
