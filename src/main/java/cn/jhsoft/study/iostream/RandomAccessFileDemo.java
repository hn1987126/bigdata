package cn.jhsoft.study.iostream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Properties;

/**
 * Created by chenyi9 on 2017/8/9.
 * 随机访问文件，要求数据有规律，也就是自己知道它里面有什么。
 * 如果没规律的，此类不适用。
 * 比如知道里面存的是姓名和年龄，如果是姓名可能是都是两个字，年龄反正是int的都是占4个字节，所以无所谓多大年纪
 * 或者如果想要有规律，可以用16个字节来表示姓名，这样每个人都是16个，不够的用空格补
 * 这样就有规律了，自己就可以算出来指针的位置，可以随机地去读和写了。
 *
 * 如果是有多线程操作同一文件，那这个类就特别适合了，每个线程去写一段。可以实现多个线程同时往一个文件写数据。
 * 断点续传，也是用的它。
 *
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
//        writeFile();
//        readFile();

        // 随机写
        randomWrite();
    }

    private static void randomWrite() throws IOException {
        // 如果没有指定位置，又会从0角标开始写数据。新的0角标覆盖原来的0角标，新的1角标覆盖原来的1角标。
        // 其它没有覆盖到的位置的数据不会动。
        RandomAccessFile raf = new RandomAccessFile("ab.txt", "rw");
        // 往指定位置写入数据
        raf.seek(5*13);
        raf.write("陈义".getBytes());
        raf.writeInt(20);
        raf.close();
    }


    private static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("ab.txt", "r");

        byte[] buf = new byte[9];
        raf.read(buf);
        System.out.println(new String(buf));
        int age = raf.readInt();
        System.out.println(age);
        System.out.println(raf.getFilePointer());
        // 通过seek设置指针的位置，这就叫随机访问，想从哪个位置读就从哪个位置读。
        raf.seek(1*13);
        // 获取当前指针所在的位置
        raf.getFilePointer();
//        buf = new byte[9];
//        raf.read(buf);
//        System.out.println(new String(buf));
//        age = raf.readInt();
//        System.out.println(age);
    }

    public static void writeFile() throws IOException {
        //如果文件不存在则创建，如果文件存在则不创建，不会覆盖，其他的输出流是覆盖。
        RandomAccessFile raf = new RandomAccessFile("ab.txt", "rw");
        raf.write("宫海涛".getBytes());
        raf.writeInt(100);
        raf.write("宫海涛".getBytes());
        raf.writeInt(100);
        raf.close();
    }

}



























