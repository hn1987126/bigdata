package cn.jhsoft.study.iostream;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class ByteArrayStreamDemo {

    public static void main(String[] args) throws Exception {
//        byteArray();

        String str = "abc你好ab你好";
        byte[] buf = str.getBytes("utf-8");
        for (int i = 1; i <= buf.length; i++) {
            System.out.println(testsubstr(str, i));
        }

        Frame f = new Frame();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("sss");
            }
        });
        f.show();
    }

    /**
     * 截取中文字符串
     * @param str  要截取的字符串
     * @param len 截取的长度
     */
    private static String testsubstr(String str, int len) throws Exception {
        byte[] buf = str.getBytes("utf-8");

        // 记录想截取的这一段之前 有多少个负数
        int count = 0;
        for (int i = len-1; i >= 0 ; i--) {
            if (buf[i] < 0){
                count ++;
            }
        }

        // 如果负数刚好是3和3的倍数，说明截取的len刚好够中文，所以直接返回相应的长度
        if (count%3 == 0){
            return new String(buf, 0, len, "utf-8");
        }else if (count % 3 == 1){// 如果负数的数量为1个或4个，那就需要返回的结果里减掉1个长度
            return new String(buf, 0, len-1, "utf-8");
        }else{// 如果负数的数量为2个或5个，那就需要返回的结果里减掉2个长度
            return new String(buf, 0, len-2, "utf-8");
        }
    }

    private static void byteArray() throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream("abcdefa".getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();


        int ch = 0;
        while ((ch = bis.read()) != -1){
            bos.write(ch);
        }
        bos.writeTo(new FileOutputStream("sb.txt"));
        System.out.println(bos.toString());
    }

}


























