package cn.jhsoft.study.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class ChatSend implements Runnable {

    private DatagramSocket ds;

    public ChatSend(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {

        try{

            // 2、将要发送的数据封装到数据包中。
            // 从键盘接收数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null){

                byte[] buf = line.getBytes();
                // ip 改为 10.12.128.255代表广播，ip在 10.12.128.1到 10.12.128.254的人都能接收到，当然是用他们的10000端口来接
                InetAddress ip = InetAddress.getByName("10.12.128.161");
                DatagramPacket dp = new DatagramPacket(buf, buf.length, ip, 10000);

                // 3、通过udp的socket服务将数据包发送出去，使用send方法。
                ds.send(dp);

                if ("886".equals(line))
                    break;
            }

            ds.close();

        }catch (Exception ex){}

    }
}
