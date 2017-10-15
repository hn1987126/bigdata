package cn.jhsoft.netty.netty3;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NettyServer {

    public static void main(String[] args) {

        // netty服务器
        ServerBootstrap bootstrap = new ServerBootstrap();

        // 两个连接池，boss兼听连接，worker兼听读写
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        // 设置netty工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));

        // 状态，这个不是必须的，在用他的时候才要用到。
        //final HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();

        // 设置netty管道工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();

                // 管道加过滤器

                // 状态，这个不是必须的，在用他的时候才要用到。
                //pipeline.addLast("idle", new IdleStateHandler(hashedWheelTimer, 5, 5, 10));

                // 解码器  指定 MyHandler 中接收的是 String 消息，如果不加下面这句，则是用 ChannelBuffer来接收
                pipeline.addLast("decoder", new StringDecoder());
                // 编码器  指定 往客户端回写的数据类型 为String
                pipeline.addLast("encoder", new StringEncoder());
                // 消息处理器
                pipeline.addLast("myHandler", new MyHandler());
                return pipeline;
            }
        });

        // 绑定端口
        bootstrap.bind(new InetSocketAddress(8888));
    }

}
