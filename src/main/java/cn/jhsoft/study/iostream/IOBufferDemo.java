package cn.jhsoft.study.iostream;

import java.io.*;

/**
 * Created by chen on 2017/8/7.
 */
public class IOBufferDemo {

    public static void main(String[] args) throws IOException {
//        writer();

//        reader();


//        readerbuffer();
//        copy();

        // LineNumberReader装饰类
        FileReader fr = new FileReader("buf.txt");
        LineNumberReader br = new LineNumberReader(fr);
        // 设置行号从哪开始
        br.setLineNumber(100);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(br.getLineNumber()+":"+line); // 获取行号
        }


    }

    private static void copy() throws IOException {
        // 文件复制
        FileReader fr = new FileReader("buf.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("buf1.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void readerbuffer() throws IOException {
        FileReader fr = new FileReader("buf.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        // 最后一行，如果不存在，返回null
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }

    private static void reader() throws IOException {
        FileReader fr = new FileReader("buf.txt");
        char[] buf = new char[1024];
        int len = 0;
        while ((len = fr.read(buf)) != -1){
            System.out.println(new String(buf, 0, len));
        }
        fr.close();
    }

    private static void writer() throws IOException {
        FileWriter fw = new FileWriter("buf.txt");
        // 为了提高写入的效率使用字符流的缓冲区。
        // 创建一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联
        BufferedWriter bw = new BufferedWriter(fw);
        // 使用缓冲区的写入方法，他的方法与Writer完全相同
        bw.write("abc");
        bw.newLine();
        bw.write("def");
        // 使用缓冲区的刷新方法将数据刷新到目的地
        bw.flush();
        // 关闭缓冲区，其实关闭的就是缓冲的流对象。关了缓冲区以后，文件的流也就关闭了。
        bw.close();
    }

}
