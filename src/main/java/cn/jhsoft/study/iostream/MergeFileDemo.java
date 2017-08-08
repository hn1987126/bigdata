package cn.jhsoft.study.iostream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by chen on 2017/8/8.
 */
public class MergeFileDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("abc");
//        mergeFile(file);
        mergeFile2(file);
    }

    private static void mergeFile2(File dir) throws IOException {

        // 取出properties文件
        File[] files = dir.listFiles(new FileFilter(".properties"));
        if (files.length != 1){
            throw new RuntimeException("配置文件错误");
        }

        // 从properties中读取信息
        Properties prop = new Properties();
        FileReader fr = new FileReader(files[0]);
        prop.load(fr);
        int fileCount = Integer.parseInt(prop.getProperty("fileCount"));
        String fileName = prop.getProperty("fileName");

        // 判断切片数量与配置文件中记录的是否一致
        File[] splitFiles = dir.listFiles(new FileFilter(".part"));
        if (splitFiles.length != fileCount){
            throw new RuntimeException("切片数量错误");
        }

        // 拼装序列流
        List<FileInputStream> list = new ArrayList<>();
        for (int i = 1; i <= fileCount; i++){
            list.add(new FileInputStream(new File(dir, i+".part")));
        }
        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(list));

        // 写到硬盘，用Output
        FileOutputStream fos = new FileOutputStream(new File(dir, fileName));
        byte[] buf = new byte[1024*1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();

    }

    private static void mergeFile(File dir) throws IOException {

        // 拼装序列流
        List<FileInputStream> list = new ArrayList<>();
        for (int i = 1; i <= 16; i++){
            list.add(new FileInputStream(new File(dir, i+".part")));
        }
        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(list));

        // 写到硬盘，用Output
        FileOutputStream fos = new FileOutputStream(new File(dir, "abc.jar"));
        byte[] buf = new byte[1024*1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();


    }

}
