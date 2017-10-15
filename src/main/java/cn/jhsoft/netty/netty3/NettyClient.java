package cn.jhsoft.netty.netty3;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyClient {

    public static void main(String[] args) {
        ClientBootstrap clientBootstrap = new ClientBootstrap();

        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        // 设置netty client工厂
        clientBootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));

        // 管道工厂
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                // 解码器  指定 MyHandler 中接收的是 String 消息，如果不加下面这句，则是用 ChannelBuffer来接收
                pipeline.addLast("decoder", new StringDecoder());
                // 编码器  指定 往客户端回写的数据类型 为String
                pipeline.addLast("encoder", new StringEncoder());
                // 消息处理器
                pipeline.addLast("myHandler", new MyClientHandler());
                return pipeline;
            }
        });

        // 连接服务端
        ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8888));
        Channel channel = connect.getChannel();
        System.out.println("客户端启动了");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入:");
            channel.write(scanner.next());
        }

    }

}
