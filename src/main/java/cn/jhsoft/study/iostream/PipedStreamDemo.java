package cn.jhsoft.study.iostream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by chenyi9 on 2017/8/9.
 */
public class PipedStreamDemo {

    public static void main(String[] args) throws IOException {
        PipedInputStream pi = new PipedInputStream();
        PipedOutputStream po = new PipedOutputStream(pi);
        // 上面是通过构造方法来连接两个管道，或者通过connect方法连接两个管道
        // po.connect(pi);
        new Thread(new Input(pi)).start();
        new Thread(new Output(po)).start();
    }

}

// 输入流
class Input implements Runnable{

    private PipedInputStream in;

    public Input(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try{

            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String s = new String(buf, 0, len);
            System.out.println("s:"+s);
            in.close();

        }catch (Exception ex){

        }
    }
}

class Output implements Runnable{

    private PipedOutputStream out;

    public Output(PipedOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
            out.write("宫海涛".getBytes());
            out.close();

        }catch (Exception ex){

        }
    }
}
