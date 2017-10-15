package cn.jhsoft.netty.netty3;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.handler.timeout.IdleState;
import org.jboss.netty.handler.timeout.IdleStateEvent;

public class MyHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

        // 接收消息  ChannelBuffer
        // ChannelBuffer转String
//        ChannelBuffer cb = (ChannelBuffer) e.getMessage();
//        String s = new String(cb.array());
//        System.out.println(s);

        // 接收消息  string，需要 netty加管理过滤器 pipeline.addLast("decoder", new StringDecoder());
        System.out.println(e.getMessage());

        // 回写消息 ChannelBuffer
//        ChannelBuffer channelBuffer = ChannelBuffers.copiedBuffer("ok".getBytes());
//        ctx.getChannel().write(channelBuffer);

        // 回写消息 String，需要 netty加管理过滤器 pipeline.addLast("encoder", new StringEncoder());
        ctx.getChannel().write("ok");

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

    // 状态，这个不是必须的，在用他的时候才要用到。
    @Override
    public void handleUpstream(final ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        if (e instanceof IdleStateEvent) {
            if(((IdleStateEvent)e).getState() == IdleState.ALL_IDLE){
                System.out.println("提玩家下线");
                //关闭会话,踢玩家下线
                ChannelFuture write = ctx.getChannel().write("time out, you will close");
                write.addListener(new ChannelFutureListener() {

                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        ctx.getChannel().close();
                    }
                });
            }
        } else {
            super.handleUpstream(ctx, e);
        }
    }

}
