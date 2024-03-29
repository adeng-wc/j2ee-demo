package com.adeng.javakcp.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import kcp.ChannelConfig;
import kcp.KcpClient;
import kcp.KcpListener;
import kcp.Ukcp;

import java.net.InetSocketAddress;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @auther wengcheng
 * @date 2022/12/29 19:58
 */
public class GameClient1 implements KcpListener {

    public static void main(String[] args) {
        ChannelConfig channelConfig = new ChannelConfig();
        channelConfig.nodelay(true, 20, 2, true);
        channelConfig.setMtu(1400);
        channelConfig.setSndwnd(256);
        channelConfig.setRcvwnd(256);
//        channelConfig.setTimeoutMillis(30 * 1000);//30s
        channelConfig.setConv(55);
//        channelConfig.setUseConvChannel(true);
        channelConfig.setAckNoDelay(false);

        KcpClient kcpClient = new KcpClient();
        kcpClient.init(channelConfig);

        GameClient1 listener = new GameClient1();
        Ukcp ukcp = kcpClient.connect(new InetSocketAddress("127.0.0.1", 10031), channelConfig, listener);

        String msg = "hello!!!!!11111111111111111111111111";
        byte[] bytes = msg.getBytes();
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer(bytes.length);
        byteBuf.writeBytes(bytes);
        ukcp.write(byteBuf);
    }

    @Override
    public void onConnected(Ukcp ukcp) {
        System.out.println("GameClient1 onConnected：");
    }

    @Override
    public void handleReceive(ByteBuf byteBuf, Ukcp ukcp) {
        System.out.println("GameClient1 handleReceive：");
    }

    @Override
    public void handleException(Throwable ex, Ukcp ukcp) {

    }

    @Override
    public void handleClose(Ukcp ukcp) {
        System.out.println("GameClient1 handleClose：");

    }
}
