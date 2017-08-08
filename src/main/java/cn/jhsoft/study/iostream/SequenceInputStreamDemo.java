package cn.jhsoft.study.iostream;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Created by chenyi9 on 2017/8/8.
 */
public class SequenceInputStreamDemo {

    public static void main(String[] args) throws IOException {

//        Vector<FileInputStream> v = new Vector<>();
//        v.add(new FileInputStream("java.txt"));
//        v.add(new FileInputStream("abc.txt"));
//
//        Enumeration<FileInputStream> en = v.elements();

        List<FileInputStream> list = new ArrayList();
        list.add(new FileInputStream("java.txt"));
        list.add(new FileInputStream("abc.txt"));
        Enumeration en = Collections.enumeration(list);
        SequenceInputStream sis = new SequenceInputStream(en);

        BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream("abc1.txt"));
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1){
            bs.write(buf, 0, len);
        }
        bs.close();
        sis.close();

    }

}
