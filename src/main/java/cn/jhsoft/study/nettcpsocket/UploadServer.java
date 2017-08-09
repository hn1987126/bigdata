package cn.jhsoft.study.nettcpsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chen on 2017/8/9.
 */
public class UploadServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10006);
        Socket socket = ss.accept();
        // 接收客户端的流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // 服务端把接收到的流写到文件中去
        BufferedWriter bw = new BufferedWriter(new FileWriter("java2.txt"));

        // 读客户端传过来的数据，并写入到文件中
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        // 给客户端发消息
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println("上传成功");

        bw.close();
        pw.close();
        socket.close();
        ss.close();

    }

}
