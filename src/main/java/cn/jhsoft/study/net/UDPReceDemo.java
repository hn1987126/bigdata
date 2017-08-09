package cn.jhsoft.study.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class UDPReceDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("接收端启动。。。");

        // 1 建立udp的socket服务，并指定监控的端口
        DatagramSocket ds = new DatagramSocket(10000);

        // 2 创建数据包
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        // 3,使用接收方法将数据存储到数据包中
        ds.receive(dp); // 阻塞式的

        // 4,通过数据包对象的方法，解析其中的数据，比如，地址，端口，数据内容
        String ip = dp.getAddress().getHostAddress();// 发送端的地址
        int port = dp.getPort();// 不是本服务端的端口，是发送端的端口
        // dp.getLength()是数据包数据的长度，数据包自己知道
        String content = new String(dp.getData(), 0, dp.getLength());
        System.out.println(ip+":"+port+":"+content);

        // 5,关闭资源
        ds.close();
    }

}
