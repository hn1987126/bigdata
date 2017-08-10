package cn.jhsoft.study.nettcpsocket;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by chenyi9 on 2017/8/10.
 */
public class MyBrowser {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("GET /web-ssm/index.jsp HTTP/1.1");
        out.println("Accept: */*");
        // 这行必须要，要访问主机的哪个端口
        out.println("Host: 127.0.0.1:8080");
        out.println("User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
        out.println("Connection: close");
        // 这行也必须要，发个空行，代表output结束。
        out.println();

        // 获取服务端返回的流
        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        in.close();
        out.close();
        socket.close();

    }

}
