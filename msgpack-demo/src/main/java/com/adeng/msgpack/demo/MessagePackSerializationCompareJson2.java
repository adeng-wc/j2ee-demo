package com.adeng.msgpack.demo;

import com.alibaba.fastjson.JSONObject;
import org.msgpack.MessagePack;
import org.msgpack.annotation.Message;

import java.io.IOException;

/**
 * @author hzwengcheng 2019-07-10 10:07
 */
public class MessagePackSerializationCompareJson2 {

    @Message // Annotation
    public static class MyMessage {
        // public fields are serialized.
        public boolean compact;
        public int schema;
        public boolean link;


        public String toString() {
            return "compact:" + compact + ";schema:" + schema + ";link:" + link;
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
        src.schema = 0;

        //利用json进行序列化
        String jsonResult = JSONObject.toJSON(src).toString();
        System.out.println("json result length:" + jsonResult.getBytes().length);

        //利用MessagePack进行序列化
        MessagePack msgpack = new MessagePack();
        // Serialize
        byte[] bytes = msgpack.write(src);
        System.out.println("msgpack result length:" + bytes.length);

    }
}
