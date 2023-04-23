package com.adeng;

public class VolatileArrObjDemo {
    private static volatile MyClass[] arr = new MyClass[2];

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            arr[0] = new MyClass(1); // 对数组元素进行写操作
            try {
                Thread.sleep(1000); // 等待1秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arr[1] = new MyClass(2); // 对数组元素进行写操作
        });

        Thread t2 = new Thread(() -> {
            MyClass myObj1 = arr[0]; // 读取数组元素
            try {
                Thread.sleep(500); // 等待0.5秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MyClass myObj2 = arr[1]; // 读取数组元素

            if (myObj1 != null ) {
                int x = myObj1.getX(); // 对对象的成员变量进行读操作
                System.out.println("arr[0]=" + x); // 输出结果
            }

            if (myObj2 != null) {
                int y = myObj2.getX(); // 对对象的成员变量进行读操作
                System.out.println("arr[0]=" + y); // 输出结果
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    static class MyClass {

        private int x;

        public MyClass(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }
    }
}
