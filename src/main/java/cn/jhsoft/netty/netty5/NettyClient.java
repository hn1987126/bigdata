package cn.jhsoft.netty.netty5;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * netty5 客户端
 */
public class NettyClient {
    public static void main(String[] args) {
        // 客户端服务类
        Bootstrap bootstrap = new Bootstrap();

        // worker
        EventLoopGroup worker = new NioEventLoopGroup();

        try {

            // 设置线程池
            bootstrap.group(worker);

            // 设置socket工厂
            bootstrap.channel(NioSocketChannel.class);

            // 设置管道工厂
            bootstrap.handler(new ChannelInitializer<Channel>() {
                @Override
                public void initChannel(Channel ch) throws Exception {
                    // 管道加过滤器
                    // 解码器  指定 MyHandler 中接收的是 String 消息，如果不加下面这句，则是用 ChannelBuffer来接收
                    ch.pipeline().addLast("decoder", new StringDecoder());
                    // 编码器  指定 往客户端回写的数据类型 为String
                    ch.pipeline().addLast("encoder", new StringEncoder());
                    // 消息处理器
                    ch.pipeline().addLast("myHandler", new MyClientHandler());
                }
            });

            // 连接
            ChannelFuture connect = bootstrap.connect("127.0.0.1", 8888);

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("请输入:");
                connect.channel().writeAndFlush(bf.readLine());
            }

        }catch (Exception ex){

        }finally {
            worker.shutdownGracefully();
        }

    }
}
