package cn.jhsoft.study.nettcpsocket;

import java.io.*;
import java.net.Socket;

/**
 * Created by chen on 2017/8/9.
 */
public class UploadImageClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("10.12.128.161", 10007);
        FileInputStream fi = new FileInputStream("readme.md");
        OutputStream out = socket.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fi.read(buf)) != -1){
            out.write(buf, 0, len);
        }
        // 结束输出
        socket.shutdownOutput();

        // 等服务端反馈
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());

        br.close();
        out.close();
        fi.close();
        socket.close();

    }

}
