package com.adeng.java.util.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by w11282 on 2018/3/16.
 */
public class ConcurrentHashMapTest {

    public static class Key{

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }


    public static void main(String[] args) {

        ConcurrentHashMap<Key, String> map = new ConcurrentHashMap<>();

        map.put(new Key(), "str1");
        map.put(new Key(), "str2");
        map.put(new Key(), "str3");
        map.put(new Key(), "str4");
        map.put(new Key(), "str5");
        map.put(new Key(), "str6");
        map.put(new Key(), "str7");
        map.put(new Key(), "str8");
        map.put(new Key(), "str9");


        System.out.println(1 << 30);
        System.out.println(1 << 31 - 1);
        System.out.println(Integer.MAX_VALUE - 8);
    }
}
