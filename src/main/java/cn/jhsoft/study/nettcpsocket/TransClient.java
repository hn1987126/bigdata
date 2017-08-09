package cn.jhsoft.study.nettcpsocket;

import java.io.*;
import java.net.Socket;

/**
 * Created by chen on 2017/8/9.
 *
 * 需求：从客户端键盘输入文字，在服务端转换成大小并输出给客户端
 *
 */
public class TransClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.31.139", 10005);

        // socket输出流 包装 加true自动刷新
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        // 从键盘取数据，输入buffer缓冲
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 等待服务端反馈回来的结果，并打印到控制台
        BufferedReader br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            if ("over".equals(line))
                break;
            // 把本行键盘输入数据发socket通信给服务端
            pw.println(line);

            // 打印服务端发过来的 大写
            System.out.println(br1.readLine());
        }

        socket.close();
        pw.close();

    }

}
