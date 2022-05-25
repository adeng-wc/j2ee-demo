package com.adeng.java9;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

/**
 * @author wengcheng on 2022/5/24
 */
public class TryTest {

    public static void main(String[] args) {
        InputStream inputStream = new StringBufferInputStream("陈哈哈");
        try (inputStream) {
            inputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
