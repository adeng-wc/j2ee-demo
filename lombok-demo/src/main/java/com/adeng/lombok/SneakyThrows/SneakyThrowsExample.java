package com.adeng.lombok.SneakyThrows;

import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;

/**
 * @author
 * @create 2018-04-21 23:26
 */
public class SneakyThrowsExample implements Runnable {

    @SneakyThrows(UnsupportedEncodingException.class)
    public String utf8ToString(byte[] bytes) {
        return new String(bytes, "UTF-8");
    }

    @SneakyThrows
    public void run() {
        throw new Throwable();
    }
}
