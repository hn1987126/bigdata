package cn.jhsoft.study.nettcpsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class ServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket sso = new ServerSocket(10001);
        // 获取客户端对象
        Socket sc = sso.accept();// 这是阻塞式的，如果没有客户端来，我就一直在等，等着提供服务
        String ip = sc.getInetAddress().getHostAddress();
        // 通过socket对象获取输入流，要读取客户端发来的数据
        InputStream in = sc.getInputStream();
        // 禁用此客户端的输出流，也就是认为他还没开始就结束了，也就是没有数据。整个while都不用执行了，因为是空的。
        // sc.shutdownInput();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            System.out.println(ip+new String(buf, 0, len));
        }

        // 给客户端回应：
        OutputStream out = sc.getOutputStream();
        out.write("收到".getBytes());

        // 关客户端
        sc.close();
        sso.close();    // 关服务端
    }

}
