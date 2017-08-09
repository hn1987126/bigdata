package cn.jhsoft.study.netsocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("10.12.128.161", 10000);
        OutputStream outputStream = sc.getOutputStream();
        outputStream.write("你好宫海涛".getBytes());
        sc.close();
    }

}
