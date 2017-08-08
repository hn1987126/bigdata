package cn.jhsoft.study.iostream;

import java.io.*;
import java.util.Properties;

/**
 * Created by chen on 2017/8/8.
 *
 * 文件切分
 *
 */
public class SplitFileDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/chen/java/bigdata/00008.jpg");
//        splitFile(file);
        splitFile2(file);
    }

    private static void splitFile2(File file) throws IOException {

        // 输入的文件的流
        FileInputStream fs = new FileInputStream(file);
        // 1M一个文件
        byte[] buf = new byte[1024*1024];

        // 输出的文件的流
        FileOutputStream fos = null;
        // 输出的文件路径
        File outFile = new File("abc");
        if (!outFile.exists()) {
            outFile.mkdirs();
        }

        int len = 0;
        int count = 1;
        while ((len = fs.read(buf)) != -1) {
            fos = new FileOutputStream(new File(outFile, (count++)+".part"));
            fos.write(buf, 0, len);
            fos.close();
        }

        // 写prop文件的流
        fos = new FileOutputStream(new File(outFile, count+".properties"));

        // 记录prop信息
        Properties prop = new Properties();
        prop.setProperty("fileCount", (count-1)+"");
        prop.setProperty("fileName", file.getName());
        prop.store(fos, "");

        fs.close();

    }

    private static void splitFile(File file) throws IOException {

        // 输入的文件的流
        FileInputStream fs = new FileInputStream(file);
        // 1M一个文件
        byte[] buf = new byte[1024*1024];

        // 输出的文件的流
        FileOutputStream fos = null;
        // 输出的文件路径
        File outFile = new File("abc");
        if (!outFile.exists()) {
            outFile.mkdirs();
        }

        int len = 0;
        int count = 1;
        while ((len = fs.read(buf)) != -1) {
            fos = new FileOutputStream(new File(outFile, (count++)+".part"));
            fos.write(buf, 0, len);
            fos.close();
        }

        fs.close();

    }

}
