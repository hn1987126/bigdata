package cn.jhsoft.study.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenyi9 on 2017/8/8.
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {
//        start();
//        method();
//        createAndDelete();

//        m2();

//        panfu();

//        list();
    }

    private static void list() {
        File file = new File("d:\\");
        String[] lists = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        for (String str : lists){
            System.out.println(str);
        }


        File file1 = new File("d:\\");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isHidden();
            }
        });
        for (File f : files){
            System.out.println(f);
        }
    }

    private static void panfu() {
        File file1 = new File("java.txt");
        System.out.println(file1.getFreeSpace());
        System.out.println(file1.getTotalSpace());

        File[] files = File.listRoots();
        for (File file : files){
            System.out.println(file);
            // 可用空间
            System.out.println(file.getFreeSpace());
            // 总容量
            System.out.println(file.getTotalSpace());
            // 给虚拟机用的空间
            System.out.println(file.getUsableSpace());
        }
    }

    private static void m2() throws IOException {
        File file = new File("abc.txt");
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
        System.out.println(file.isDirectory());

        file.renameTo(new File("abc2.txt"));
    }

    private static void createAndDelete() throws IOException {
        File file = new File("abc.txt");
        boolean b = file.createNewFile();
        System.out.println(b);
        b = file.delete();
        System.out.println(b);
        file.deleteOnExit();

        File file1 = new File("abc\\a\\b\\c");
        file1.mkdirs();
        file1.delete();
    }

    private static void method() {
        File file = new File("a.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.length());
        System.out.println("剩余空间："+file.getFreeSpace());
        System.out.println(file.lastModified());
        long time = file.lastModified();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date(time)));
        System.out.println("父路径"+file.getParent());
    }

    private static void start() {
        // 构造方法
        File file = new File("abc.txt");
        File file1 = new File("c:\\","abc.txt");
        File file2 = new File("c:\\");
        File file3 = new File(file2, "abc.txt");

        // 字段
        // 路径分隔符 File.pathSeparator，如 unix是: windows是; 主要是在环境变量里用。
        // 文件分隔符 File.separator
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }
}





























