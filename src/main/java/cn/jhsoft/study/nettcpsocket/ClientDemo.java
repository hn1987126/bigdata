package cn.jhsoft.study.nettcpsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("192.168.31.139", 10001);
        OutputStream outputStream = sc.getOutputStream();
        outputStream.write("你好宫海涛".getBytes());// 发给服务端

        // 告诉服务端，我的输入流写完了，完事了。也就是写个结束标记，不然服务器端会一直等着读，也不知道你写完了。
        sc.shutdownOutput();

        // 接收服务器端的回应，使用socket读取流
        InputStream in = sc.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf, 0, len));

        sc.close();
    }

}
