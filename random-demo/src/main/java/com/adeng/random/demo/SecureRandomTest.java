package com.adeng.random.demo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author wengcheng on 2022/5/24
 */
public class SecureRandomTest {

    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        if (bytes == null) return "";
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        SecureRandom random1 = SecureRandom.getInstance("SHA1PRNG");
        SecureRandom random2 = SecureRandom.getInstance("SHA1PRNG");

        for (int i = 0; i < 5; i++) {
            System.out.println(random1.nextInt() + " != " + random2.nextInt());
        }

        System.out.println("---------------------");

        SecureRandom random3 = new SecureRandom();
        SecureRandom random4 = new SecureRandom();

        byte[] bytes3 = new byte[20];
        random3.nextBytes(bytes3);
        for (byte b : bytes3) {
            System.out.print(b);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(bytesToHex(bytes3));

        byte[] bytes4 = new byte[20];
        random4.nextBytes(bytes4);
        for (byte b : bytes4) {
            System.out.print(b);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(bytesToHex(bytes4));
    }
}
