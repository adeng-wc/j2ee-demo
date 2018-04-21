package com.adeng.lombok.Cleanup;

import lombok.Cleanup;

import java.io.*;

/**
 * 默认cleanup调用的是close方法，如果不是可以指定清理的方法名称（这里要是无参方法）
 *
 * @author
 * @create 2018-04-21 21:51
 */
public class CleanupExample {

    public static void main(String[] args) throws IOException {
        @Cleanup InputStream in = new FileInputStream(args[0]);
        @Cleanup("close") OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }
}
