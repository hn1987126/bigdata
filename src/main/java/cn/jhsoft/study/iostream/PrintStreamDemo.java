package cn.jhsoft.study.iostream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by chenyi9 on 2017/8/8.
 */
public class PrintStreamDemo {

    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream("print1.txt");
        // write方法只写最低8位，整数在内存中是占4个字节，他就是4组8位数组成，这里只取最后8位，
        // 所以导致如果write(610) 会把b写进去，因为他除最后8位之外的都被忽略了。
        // 把97对应的 Accis码 a 写入到文件中。
        // 如果write想原样写入 97，可以 out.write((97+"sb").getBytes()) 写入字节进去。
        out.write(97);
        out.print(97); // 将97先变成字符 保持原样将数据打印到目的地。
        out.close();
    }

}
