package cn.jhsoft.study.nettcpsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chen on 2017/8/9.
 */
public class TransServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10005);
        Socket socket = ss.accept();    // 获取socket客户端，阻塞式的
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 给客户端写转换大写的数据的流
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        String line = null;
        while ((line = br.readLine()) != null) {
            // 输出客户端发过来的一行数据
            System.out.println(line);
            // 给客户端转化大写发socket过去
            pw.println(line.toUpperCase());
        }

        br.close();
        pw.close();
        ss.close();

    }

}
