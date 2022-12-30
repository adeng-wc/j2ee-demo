package com.adeng.javakcp.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.DefaultEventLoop;
import kcp.KcpListener;
import kcp.Ukcp;
import lombok.Getter;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther wengcheng
 * @date 2022/12/29 16:03
 */
public class GameSessionManager {
    private static final DefaultEventLoop logicThread = new DefaultEventLoop();
    @Getter private static final ConcurrentHashMap<Ukcp, GameSession> sessions = new ConcurrentHashMap<>();

    @Getter private static final KcpListener listener = new KcpListener() {
        @Override
        public void onConnected(Ukcp ukcp) {
            System.out.println("KcpListener.onConnected: 有连接进来,当前连接");

            int times = 0;
            GameServer server = Main.getGameServer();
            while (server == null) {//Waiting server to establish
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    ukcp.close();
                    return;
                }
                if (times++ > 5) {
                    ukcp.close();
                    return;
                }
                server = Main.getGameServer();
            }

            GameSession conversation = new GameSession(server);
            conversation.onConnected(new KcpTunnel() {
                @Override
                public InetSocketAddress getAddress() {
                    return ukcp.user().getRemoteAddress();
                }

                @Override
                public void writeData(byte[] bytes) {
                    ByteBuf buf = Unpooled.wrappedBuffer(bytes);
                    ukcp.write(buf);
                    buf.release();
                }

                @Override
                public void close() {
                    ukcp.close();
                }
            });
            sessions.put(ukcp, conversation);
        }

        @Override
        public void handleReceive(ByteBuf buf, Ukcp kcp) {
            byte[] bytes = new byte[buf.readableBytes()];
            buf.getBytes(buf.readerIndex(), bytes);
            System.out.println("KcpListener.handleReceive: 收到消息 " + new String(bytes));

            byte[] byteData = byteBufToArray(buf);
            logicThread.execute(() -> {
                try {
                    GameSession conversation = sessions.get(kcp);
                    if (conversation != null) {
                        conversation.handleReceive(byteData);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        @Override
        public void handleException(Throwable ex, Ukcp ukcp) {

        }

        @Override
        public void handleClose(Ukcp ukcp) {
            System.out.println("KcpListener.handleClose: 收到消息 ");
            GameSession conversation = sessions.get(ukcp);
            if (conversation != null) {
                conversation.handleClose();
                sessions.remove(ukcp);
            }
        }
    };

    public static byte[] byteBufToArray(ByteBuf buf) {
        byte[] bytes = new byte[buf.capacity()];
        buf.getBytes(0, bytes);
        return bytes;
    }

    interface KcpTunnel {
        InetSocketAddress getAddress();

        void writeData(byte[] bytes);

        void close();
    }

    interface KcpChannel {
        void onConnected(KcpTunnel tunnel);

        void handleClose();

        void handleReceive(byte[] bytes);
    }
}
