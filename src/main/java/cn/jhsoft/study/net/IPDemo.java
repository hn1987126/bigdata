package cn.jhsoft.study.net;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class IPDemo {

    public static void main(String[] args) throws Exception {
        ip();




    }

    private static void ip() throws UnknownHostException {
        //获取本地主机IP地址对象
        InetAddress ip = InetAddress.getLocalHost();
        // 获取其它主机的ip地址对象
        //ip = InetAddress.getByName("jd.com");
        // IP地址
        System.out.println(ip.getHostAddress());
        // 主机名，会根据ip去解析
        System.out.println(ip.getHostName());
    }

}
