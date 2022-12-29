package com.adeng.javakcp.server;

import lombok.Getter;

/**
 * @auther wengcheng
 * @date 2022/12/29 17:19
 */
public class Main {

    @Getter private static GameServer gameServer;

    public static void main(String[] args) {
        gameServer = new GameServer();
        gameServer.start();
    }
}
