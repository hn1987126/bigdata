package cn.jhsoft.study.netsocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class ServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket sso = new ServerSocket(10000);
        // 获取客户端对象
        Socket s = sso.accept();
        String ip = s.getInetAddress().getHostAddress();
        // 通过socket对象获取输入流，要读取客户端发来的数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            System.out.println(ip+new String(buf, 0, len));
        }
        // 关客户端
        s.close();
        sso.close();    // 关服务端
    }

}
