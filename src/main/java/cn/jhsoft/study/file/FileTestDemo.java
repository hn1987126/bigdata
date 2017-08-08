package cn.jhsoft.study.file;

import java.io.File;

/**
 * Created by chenyi9 on 2017/8/8.
 */
public class FileTestDemo {

    public static void main(String[] args) {
        File dir = new File("D:\\BaiduNetdiskDownload\\黑马程序员_历经5年锤炼(适合初学者入门的Java基础视频)");
        listAll(dir);
    }

    /**
     * 递归遍历某目录下的所有文件和目录，以及目录里的子目录
     * @param dir
     */
    private static void listAll(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
            System.out.println(f);
            if (f.isDirectory()){
                listAll(f);
            }
        }
    }

}
