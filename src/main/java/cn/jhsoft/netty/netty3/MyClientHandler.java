package cn.jhsoft.netty.netty3;

import org.jboss.netty.channel.*;

public class MyClientHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

        // 接收消息  ChannelBuffer
        // ChannelBuffer转String
//        ChannelBuffer cb = (ChannelBuffer) e.getMessage();
//        String s = new String(cb.array());
//        System.out.println(s);

        // 接收消息  string，需要 netty加管理过滤器 pipeline.addLast("decoder", new StringDecoder());
        System.out.println(e.getMessage());

        super.messageReceived(ctx, e);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println("异常了");
        super.exceptionCaught(ctx, e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("连接上了");
        super.channelConnected(ctx, e);
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("连接断开了");
        super.channelDisconnected(ctx, e);
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("关闭并释放资源");
        super.channelClosed(ctx, e);
    }
}
