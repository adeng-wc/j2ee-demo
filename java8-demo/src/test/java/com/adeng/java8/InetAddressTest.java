package com.adeng.java8;

import org.junit.Test;

import java.net.InetAddress;

public class InetAddressTest {
    @Test
    public void test() throws Exception {
        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
    }

}
