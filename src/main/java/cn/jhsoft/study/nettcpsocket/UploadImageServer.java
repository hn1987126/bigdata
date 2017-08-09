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
        Socket socket = ss.accept();

        // 要写的文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("readme2.md"));
        // 取客户端流
        InputStream is = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = is.read(buf)) != -1){
            bos.write(buf, 0, len);
        }

        // 写客户端写成功信息
        OutputStream out = socket.getOutputStream();
        out.write("上传成功！".getBytes());
        out.close();

        is.close();
        bos.close();
        socket.close();
        ss.close();

    }

}
