package cn.jhsoft.study.nettcpsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chen on 2017/8/9.
 */
public class UploadImageServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10007);

        while (true) {
            Socket s = ss.accept();
            // 多线程接收多客户端
            new Thread(new UploadImageTask(s)).start();

        }
        // 上面的while循环，如果是一直在空转，系统会爆掉，因为里面有运算，会占用机器资源。
        // 但如果里面有阻塞函数(如ss.accept()，还有read也是阻塞式函数)，那就不会爆，因为那里会在等待，并不占系统资源。

        // 因为是一直循环着，所以这个ss就不需要关闭了
        //ss.close();

    }

}
