package com.adeng.javakcp.server;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther wengcheng
 * @date 2022/12/29 15:36
 */
public class GameSession implements GameSessionManager.KcpChannel {

    @Getter private GameServer server;
    private GameSessionManager.KcpTunnel tunnel;
    @Getter @Setter private SessionState state;
    @Getter private int clientTime;
    @Getter private long lastPingTime;
    private int lastClientSeq = 10;

    public GameSession(GameServer server) {
        this.server = server;
        this.state = SessionState.WAITING_FOR_TOKEN;
        this.lastPingTime = System.currentTimeMillis();
    }

    @Override
    public void onConnected(GameSessionManager.KcpTunnel tunnel) {
        this.tunnel = tunnel;
        System.out.println("GameSession.onConnected: 新 KcpTunnel 接入");
    }

    @Override
    public void handleClose() {
        // 连接关闭
        System.out.println("GameSession.handleClose: KcpTunnel close");
        setState(SessionState.INACTIVE);
        tunnel = null;
    }

    @Override
    public void handleReceive(byte[] bytes) {
        // 接受消息，解析报文

    }

    public void close() {
        tunnel.close();
    }

    public boolean isActive() {
        return getState() == SessionState.ACTIVE;
    }

    public enum SessionState {
        INACTIVE,
        WAITING_FOR_TOKEN,  // 玩家信息，在这个状态下获得；先通过 http 接口获得Token，然后使用 udp 操作Token登录
        WAITING_FOR_LOGIN,  // token 校验通过，player 创建成功
        PICKING_CHARACTER,
        ACTIVE,
        ACCOUNT_BANNED
    }
}
