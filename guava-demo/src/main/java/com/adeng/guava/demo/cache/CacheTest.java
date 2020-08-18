package com.adeng.guava.demo.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CacheTest {


    @Test
    public void test() throws Exception {
        // 通过CacheBuilder构建一个缓存实例
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100) // 设置缓存的最大容量
                .expireAfterWrite(5, TimeUnit.SECONDS) // 设置缓存在写入一分钟后失效
                .concurrencyLevel(10) // 设置并发级别为10
                .recordStats() // 开启缓存统计
                .build();
        // 放入缓存
        cache.put("key", "value");
        // 获取缓存
        String value = cache.getIfPresent("key");
        System.out.println(value);
        Thread.sleep(3000);
        cache.put("key2", "value2");
        Thread.sleep(1000);
        cache.put("key", "value");
        Thread.sleep(2000);
        Thread.sleep(2000);
        String value2 = cache.getIfPresent("key");
        if (value2 == null) {
            System.out.println("null is null");
        } else {
            System.out.println(value2);
        }

        System.out.println(cache.getIfPresent("key2"));
    }
}
