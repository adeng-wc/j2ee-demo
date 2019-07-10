package com.adeng.msgpack.demo;

import org.msgpack.MessagePack;
import org.msgpack.annotation.Message;

import java.io.IOException;

/**
 * 顺序不同，类型不同
 *
 * @author hzwengcheng 2019-07-10 10:15
 */
public class SimpleMessagePackPractice2 {

    @Message // Annotation
    public static class MyMessage {
        public boolean compact;
        public String link;

        public String toString() {
            return "link:" + link + ";compact:" + compact;
        }
    }

    @Message // Annotation
    public static class MyMessage2 {
        public String link;
        public boolean compact;

        public String toString() {
            return "link:" + link + ";compact:" + compact;
        }
    }

    /**
     * 属性不一致会解析失败。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //初始化一个对象
        MyMessage src = new MyMessage();
        src.compact = true;
        src.link = "www.baidu.com";

        //利用MessagePack进行序列化
        MessagePack msgpack = new MessagePack();
        // Serialize
        byte[] bytes = msgpack.write(src);

        //利用MessagePack进行反序列化
        MyMessage2 dst = msgpack.read(bytes, MyMessage2.class);
        System.out.println("msgpack 原始数据:" + src);
        System.out.println("msgpack 反序列化:" + dst);
    }
}
