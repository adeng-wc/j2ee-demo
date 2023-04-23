package com.adeng;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class VolatileArrDemo {

//    private static AtomicIntegerArray[] arr = new AtomicIntegerArray[2];
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            arr.set(0, 1);
////            arr[0] = 1;  // 对数组元素进行写操作
//            try {
//                Thread.sleep(1000); // 等待1秒钟
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            arr[1] = 2;  // 对数组元素进行写操作
//        });
//
//        Thread t2 = new Thread(() -> {
//            int x = arr[0]; // 读取数组元素
//            try {
//                Thread.sleep(500); // 等待0.5秒钟
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            int y = arr[1]; // 读取数组元素
//            System.out.println("x=" + x + ", y=" + y); // 输出结果
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//    }
}
