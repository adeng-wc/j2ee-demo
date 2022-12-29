package com.adeng.javakcp.client;

import io.netty.buffer.ByteBuf;
import kcp.KcpListener;
import kcp.Ukcp;

/**
 * @auther wengcheng
 * @date 2022/12/29 19:58
 */
public class GameClient1 implements KcpListener {

    public static void main(String[] args) {

    }

    @Override
    public void onConnected(Ukcp ukcp) {

    }

    @Override
    public void handleReceive(ByteBuf byteBuf, Ukcp ukcp) {

    }

    @Override
    public void handleException(Throwable ex, Ukcp ukcp) {

    }

    @Override
    public void handleClose(Ukcp ukcp) {

    }
}
