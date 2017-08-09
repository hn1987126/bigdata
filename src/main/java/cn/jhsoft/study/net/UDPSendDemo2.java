package cn.jhsoft.study.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class UDPSendDemo2 {

    public static void main(String[] args) throws Exception {

        System.out.println("发送端启动。。。");

        // 创建一个UDP传输的发送端
        /*
        1、建立udp的socket服务。（使用DatagramSocket对象）
        2、将要发送的数据封装到数据包中。
        3、通过udp的socket服务将数据包发送出去。
        4、关闭socket服务。
        * */

        // 1、udp socket服务，使用DatagramSocket对象，
        // 如果在这构造方法里写个端口进去，如8888，是代表以这个端口来发送，如果不指定，则随机。
        DatagramSocket ds = new DatagramSocket();

        // 2、将要发送的数据封装到数据包中。
        // 从键盘接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null){

            if ("886".equals(line))
                break;

            byte[] buf = line.getBytes();
            InetAddress ip = InetAddress.getByName("10.12.128.161");
            DatagramPacket dp = new DatagramPacket(buf, buf.length, ip, 10000);

            // 3、通过udp的socket服务将数据包发送出去，使用send方法。
            ds.send(dp);
        }

        // 4、关闭资源
        ds.close();
    }

}

















