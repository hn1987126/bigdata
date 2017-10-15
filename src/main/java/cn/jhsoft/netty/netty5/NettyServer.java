package cn.jhsoft.netty.netty5;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

public class NettyServer {

    public static void main(String[] args) {

        // 服务类
        ServerBootstrap bootstrap = new ServerBootstrap();

        // boss 和 worker
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            // 设置线程池
            bootstrap.group(boss, worker);

            // 设置socket工厂
            bootstrap.channel(NioServerSocketChannel.class);

            // 设置管道工厂
            bootstrap.childHandler(new ChannelInitializer<Channel>() {
                @Override
                public void initChannel(Channel ch) throws Exception {
                    // 管道加过滤器
                    // 解码器  指定 MyHandler 中接收的是 String 消息，如果不加下面这句，则是用 ChannelBuffer来接收
                    ch.pipeline().addLast("decoder", new StringDecoder());
                    // 编码器  指定 往客户端回写的数据类型 为String
                    ch.pipeline().addLast("encoder", new StringEncoder());
                    // 检测会话状态
                    ch.pipeline().addLast(new IdleStateHandler(5, 5, 10));
                    // 消息处理器
                    ch.pipeline().addLast("myHandler", new MyServerHandler());
                }
            });

            // 设置参数-TCP参数，这个可以省略，完全不需要设置
            bootstrap.option(ChannelOption.SO_BACKLOG, 2048); // serverSocketchannel设置，链接缓冲池的大小
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true); // socketchannel设置，维持链接的活跃，清除一些死链接
            bootstrap.option(ChannelOption.TCP_NODELAY, true); // socketchannel设置，关闭延迟发送
            // netty3中对应的设置如下：
            //bootstrap.setOption("backlog", 1024);
            //bootstrap.setOption("tcpNoDelay", true);
            //bootstrap.setOption("keepAlive", true);

            // 绑定端口
            ChannelFuture future = bootstrap.bind(8888);

            System.out.println("server start");

            // 等待服务器关闭
            future.channel().closeFuture().sync();
        }catch (Exception ex){

        }finally {
            // 释放资源
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

}
