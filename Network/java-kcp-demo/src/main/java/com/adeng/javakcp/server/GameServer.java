package com.adeng.javakcp.server;

import kcp.ChannelConfig;
import kcp.KcpServer;

import java.time.Instant;
import java.util.*;

/**
 * 服务端
 *
 * @auther wengcheng
 * @date 2022/12/29 15:14
 */
public class GameServer extends KcpServer {

    public GameServer() {
        ChannelConfig channelConfig = new ChannelConfig();
        channelConfig.nodelay(true, 20, 2, true);
        channelConfig.setMtu(1400);
        channelConfig.setSndwnd(256);
        channelConfig.setRcvwnd(256);
        channelConfig.setTimeoutMillis(30 * 1000);//30s
        channelConfig.setUseConvChannel(true);
        channelConfig.setAckNoDelay(false);

        this.init(GameSessionManager.getListener(), channelConfig, 10031);

        // Hook into shutdown event.
        Runtime.getRuntime().addShutdownHook(new Thread(this::onServerShutdown));
    }

    public void start() {
        System.out.println("GameServer.start......");
        // Schedule game loop.
        Timer gameLoop = new Timer();
        gameLoop.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    onTick();
                } catch (Exception e) {
                    System.out.println("GameServer.onTick Exception:" + e);
                }
            }
        }, new Date(), 1000L);   // 1s 执行一次
    }

    public synchronized void onTick() {
        var tickStart = Instant.now();
        System.out.println("GameServer.onTick: Session " + GameSessionManager.getSessions().size());
    }

    public void onServerShutdown() {
        System.out.println("GameServer.onServerShutdown......");
    }
}
