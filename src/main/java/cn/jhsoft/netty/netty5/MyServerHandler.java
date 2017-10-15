package cn.jhsoft.netty.netty5;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);

        // 回写并flush刷新
        channelHandlerContext.writeAndFlush("ok");
        // 或者，如下这样写，这两种写法完全相同
        //channelHandlerContext.channel().writeAndFlush("ok2");
    }

    /**
     * 新客户端接入
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
    }

    /**
     * 客户端断开
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
    }

    /**
     * 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    /**
     * 检测会话状态
     */
    @Override
    public void userEventTriggered(final ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;

            //清除超时会话
            if(event.state() == IdleState.ALL_IDLE){
                ChannelFuture future = ctx.channel().writeAndFlush("this is my time out");

                // 往客户端写数据，并加兼听事件，写完以后才会执行关闭操作
                future.addListener(new GenericFutureListener<Future<? super Void>>() {
                    @Override
                    public void operationComplete(Future<? super Void> future) throws Exception {
                        // 操作，踢下线
                        ctx.channel().close();
                    }
                });
            }
        }else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
