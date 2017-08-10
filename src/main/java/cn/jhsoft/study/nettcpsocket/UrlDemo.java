package cn.jhsoft.study.nettcpsocket;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by chenyi9 on 2017/8/10.
 */
public class UrlDemo {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://127.0.0.1:8080/web-ssm/index.jsp?a=1&b=2");
        System.out.println("协议:"+url.getProtocol());
        System.out.println("主机名:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        System.out.println("页面+参数:"+url.getFile());
        System.out.println("页面地址:"+url.getPath());
        System.out.println("参数:"+url.getQuery());

        // 获取url连上去的这个socket 服务端返回来的 流
        InputStream in = url.openStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        // 获取url对象的url连接器对象，它是将连接封装成了对象
        // 这个对象就是java中内置的可以解析的具体协议对象 + socket
        // 上面的 url.openStream() 就是对 conn.getInputStream() 进行了一层包装。
        URLConnection conn = url.openConnection();
        // 获取头信息里的 Content-Type
        System.out.println(conn.getHeaderField("Content-Type"));

        // 通过 URLConnection 来获取输入流
        InputStream in1 = conn.getInputStream();
        byte[] buf1 = new byte[1024];
        int len1 = 0;
        while ((len1 = in1.read(buf1)) != -1) {
            System.out.println(new String(buf1, 0, len1));
        }



    }

}
