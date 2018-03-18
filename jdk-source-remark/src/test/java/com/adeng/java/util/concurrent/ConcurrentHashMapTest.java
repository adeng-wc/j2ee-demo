package com.adeng.java.util.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by w11282 on 2018/3/16.
 */
public class ConcurrentHashMapTest {

    public static class Key {

        @Override
        public int hashCode() {
            return 31;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }


    public static void main(String[] args) {

        ConcurrentHashMap<Key, String> map = new ConcurrentHashMap<>(64);


        for (int i = 1; i < 33; i++) {
            map.put(new Key(), "str" + 1);
        }


        System.out.println(1 << 30);
        System.out.println(1 << 31 - 1);
        System.out.println(Integer.MAX_VALUE - 8);
    }
}
