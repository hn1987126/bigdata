package cn.jhsoft.study.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by chenyi9 on 2017/8/8.
 */
public class PrintWriterDemo {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        // 第二个参数是指定是否需要自动刷新，如果自动刷新，下面不需要再写out.flush()
        out = new PrintWriter(new FileWriter("abc.txt"), true);
        String line = null;
        while ((line = br.readLine()) != null) {
            if ("over".equals(line))
                break;

            out.println(line.toUpperCase()); // println 会自动换行，相当于原来的 newLine();而且newLine还需要输入流缓冲才能有这方法
            // 构造方法里如果是true，这行可以注释掉。
            //out.flush();
        }
        out.close();
        br.close();

    }

}
