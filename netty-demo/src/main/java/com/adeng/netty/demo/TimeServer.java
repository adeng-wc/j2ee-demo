package com.adeng.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Date;

/**
 * @author hzwengcheng 2019-12-27 5:23 下午
 */
public class TimeServer {

    private class TimeServerHandler extends ChannelHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 将 msg 转换成 Netty 的 ByteBuf 对象
            ByteBuf buf = (ByteBuf) msg;
            // readableBytes 方法可以获取缓冲区可读的字节数
            byte[] req = new byte[buf.readableBytes()];
            // 将缓冲区中的字节数组复制到新建的 byte 数组
            buf.readBytes(req);
            String body = new String(req, "UTF-8");
            System.out.println("The time server receive order:" + body);
            String currentTime = "query time order".equalsIgnoreCase(body) ?
                    new Date(System.currentTimeMillis()).toString() : "Bad order";
            ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
            // write 方法异步发送应答消息给客户端
            ctx.write(resp);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            // 将消息发送队列中的消息写入到 SocketChannel
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            // 关闭 ChannelHandlerContext， 释放 ChannelHandlerContext 相关关联的句柄
            ctx.close();
        }
    }

    private class CustomChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }

    public void bind(int port) {
        // 配置服务端的 NIO 线程组（Reactor 线程组）
        // 一个用于服务端接受客户端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 一个用于 SockChannel 的网络读写
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // ServerBootstrap 是 Netty 用于启动 NIO 服务端的辅助启动类
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    // 最后绑定 I/O 事件的处理类，主要用于处理网络 I/O 事件，例如记录日志、对消息进行编解码等
                    .childHandler(new CustomChannelHandler());

            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅退出
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        new TimeServer().bind(port);
    }
}
