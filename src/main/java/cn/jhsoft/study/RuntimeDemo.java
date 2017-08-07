package cn.jhsoft.study;

import java.io.IOException;
import java.util.Random;

/**
 * Created by chenyi9 on 2017/8/7.
 */
public class RuntimeDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        /*Runtime r = Runtime.getRuntime();
        // 打开记事本，并读取log文件
        Process p = r.exec("notepad.exe C:\\sys001.log");
        Thread.sleep(5000);
        // 杀掉这个进程，只能杀自己开的，非自己开的不能杀
        p.destroy();*/

        System.out.println(Math.ceil(12.56));
        System.out.println(Math.floor(12.56));
        System.out.println(Math.round(12.56));

        System.out.println(Math.PI);

        for (int i = 0; i < 10; i++) {
            double d = Math.ceil(Math.random()*10);
            double d1 = (int)(Math.random()*10+1);
            //System.out.println(d1);
            Random r = new Random();
            System.out.println(r.nextInt());
        }
    }

}
