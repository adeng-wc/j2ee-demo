package com.adeng.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author hzwengcheng 2019-12-28 4:56 下午
 */
public class TimeClient {

    /**
     * channelActive 、 channelRead 和 exceptionCaught 。
     * 当客户端和服务端 TCP 链路建立成功之后，Netty de NIO 线程会调用 channelActive 方法，发送查询时间的指令到服务端，
     * 调用
     */
    public class TimeClinetHandler extends ChannelHandlerAdapter {

        private final ByteBuf firstMessage;

        public TimeClinetHandler() {
            byte[] req = "query time order".getBytes();
            firstMessage = Unpooled.buffer(req.length);
            firstMessage.writeBytes(req);
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            // 调用 writeAndFlush 方法将请求消息发送给服务端
            ctx.writeAndFlush(firstMessage);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "UTF-8");
            System.out.println("Now is :" + body);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }
    }

    public void connect(int port, String host) {
        // 配置客户端 NIO 线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    // 实现 initChannel 方法，作用是当创建 NioSocketChannel 成功之后，进行初始化，
                    // 将它的 ChannelHandler 设置到 ChannelPipeline 中，用于处理网络 I/O 事件
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new TimeClinetHandler());
                        }
                    });

            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();
            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅退出，释放 NIO 线程组
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        new TimeClient().connect(port, "127.0.0.1");
    }
}
