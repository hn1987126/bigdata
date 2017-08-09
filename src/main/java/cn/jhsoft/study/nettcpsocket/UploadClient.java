package cn.jhsoft.study.nettcpsocket;

import java.io.*;
import java.net.Socket;

/**
 * Created by chen on 2017/8/9.
 *
 * 需求：上传文本文件
 * 服务器端给上传成功的回馈
 */
public class UploadClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.31.139", 10006);
        // 上传的文件的缓冲流
        BufferedReader br = new BufferedReader(new FileReader("java.txt"));
        // 给服务端传的socket流
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        String line = null;
        while ((line = br.readLine()) != null) {
            pw.println(line);
        }
        // 给服务端结束标记
        socket.shutdownOutput();

        // 接收服务器消息的流
        BufferedReader br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br1.readLine());
    }

}
