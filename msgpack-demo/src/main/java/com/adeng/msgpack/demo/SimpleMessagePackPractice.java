package com.adeng.msgpack.demo;

import org.msgpack.MessagePack;
import org.msgpack.annotation.Message;

import java.io.IOException;

/**
 * 顺序不同，类型相同
 *
 * @author hzwengcheng 2019-07-10 10:12
 */
public class SimpleMessagePackPractice {

    @Message // Annotation
    public static class MyMessage {
        // public fields are serialized.
        public boolean compact;
        public boolean link;

        public String toString() {
            return "link:" + link + ";compact:" + compact;
        }
    }

    @Message // Annotation
    public static class MyMessage2 {
        // public fields are serialized.
        public boolean link;
        public boolean compact;

        public String toString() {
            return "link:" + link + ";compact:" + compact;
        }
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //初始化一个对象
        MyMessage src = new MyMessage();
        src.compact = true;
        src.link = false;

        //利用MessagePack进行序列化
        MessagePack msgpack = new MessagePack();
        // Serialize
        byte[] bytes = msgpack.write(src);

        //利用MessagePack进行反序列化
        MyMessage2 dst = msgpack.read(bytes, MyMessage2.class);
        System.out.println("msgpack 原始数据:" + src);
        System.out.println("msgpack 反序列化:" + dst);

        /*
            顺序不同，解析的属性不同

            msgpack 原始数据:link:false;compact:true
            msgpack 反序列化:link:true;compact:false
         */

    }
}
