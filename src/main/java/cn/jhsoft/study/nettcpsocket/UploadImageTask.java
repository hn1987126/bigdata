package cn.jhsoft.study.nettcpsocket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chenyi9 on 2017/8/10.
 */
public class UploadImageTask implements Runnable {


    private Socket socket;

    public UploadImageTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{

            // 打印连过来的客户端ip
            System.out.println(socket.getInetAddress().getHostName());

            // 上传后的文件名
            int count = 0;
            File file = new File("readme2.md");
            while (file.exists()){
                file = new File("readme2("+(++count)+").md");
            }

            // 要写的文件
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            // 取客户端流
            InputStream in = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }

            // 写客户端写成功信息
            OutputStream out = socket.getOutputStream();
            out.write("上传成功！".getBytes());
            out.close();

            in.close();
            bos.close();
            socket.close();

        }catch (Exception ex){

        }
    }
}
