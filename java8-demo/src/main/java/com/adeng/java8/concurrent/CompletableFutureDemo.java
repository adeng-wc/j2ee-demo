package com.adeng.java8.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步、并发
 *
 * @author hzwengcheng 2018-06-18 09:49
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //异步
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->
                String.format("[Thread: %s]Hello,world!", Thread.currentThread().getName()));

        String value = completableFuture.get();
        System.out.println("value: " + value);
        System.out.println("starting");
        System.out.println("--------------------------");

        //聚合
        CompletableFuture combinedFuture =
                CompletableFuture.supplyAsync(() -> CombinedEntity.builder().build())
                        .thenApply(entity -> {

                            entity.setName("TestName:" + System.currentTimeMillis());
                            return entity;
                        }).thenRun(() -> {

                });

        while (!combinedFuture.isDone()){

        }

        CombinedEntity entity = (CombinedEntity) combinedFuture.get();

        System.out.println(entity);
    }


}
