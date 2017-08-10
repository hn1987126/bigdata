package cn.jhsoft.study.nettcpsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chenyi9 on 2017/8/10.
 * 模拟Tomcat行为，本类作为服务器端，浏览器可以访问本类提供的服务
 */
public class MyTomcat {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8089);
        Socket socket = ss.accept();

        // 打印客户端浏览器，发过来的流
        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
            break;
        }
        socket.shutdownInput();

        // 给浏览器客户端返回数据
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println("Welcome My Tomcat");

        socket.close();
        ss.close();

    }

}
