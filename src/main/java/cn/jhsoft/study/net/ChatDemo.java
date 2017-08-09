package cn.jhsoft.study.net;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class ChatDemo {
    public static void main(String[] args) throws Exception {

        DatagramSocket send_Socket = new DatagramSocket();
        DatagramSocket rece_Socket = new DatagramSocket(10000);

        new Thread(new ChatSend(send_Socket)).start();
        new Thread(new ChatRece(rece_Socket)).start();

    }
}
