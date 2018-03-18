package com.adeng.java.util.concurrent;

public class NumberOfLeadingZerosTest {

    public static void main(String[] args) {

        /*
            首先在jvm中一个int类型的数据占4个字节，共32位，其实就相当于一个长度为32的数组。
            那我们要计算首部0的个数，就是从左边第一个位开始累加0的个数，直到遇到一个非零值。
         */

        /*
           下面的代码就是定位从左边开始第一个非零值的位置，在定位过程中顺便累加从左边开始0的个数
           将i无符号右移16位后，有二种情况；
           情况1.i=0,则第一个非零值位于低16位，i至少有16个0，同时将i左移16位（把低16位移到原高16位的位置，这样情况1和情况2就能统一后续的判断方式）
           情况2.i!=0,则第一个非零值位于高16位，后续在高16位中继续判断
           这个思路就是二分查找，首先把32位的数分为高低16位，如果非零值位于高16位，后续再将高16位继续二分为高低8位，一直二分到集合中只有1个元素
         */

        //前面指定i 数组长度是小于 1 << 30 的

        int i = 16;

        if (i == 0)
            System.out.println(32);
        int n = 1;
        System.out.println(i);   //16
        System.out.println(Integer.toBinaryString(i));//0 0000 0000 0000 0001 0000
        System.out.println("-----------------------");
        /*
            i >>> 16 == 0,判断 i 是不是小于 2^15次，
            如果小于，n + 16,否则 i <<= 16 ，扩大2^16倍
         */
        if (i >>> 16 == 0) {
            n += 16;
            i <<= 16;
        }
        System.out.println(i);//1048576
        System.out.println(Integer.toBinaryString(i));//0 0000 0001 0000 0000 0000 0000 0000
        System.out.println(n);//1 + 16 = 17
        System.out.println(Integer.toBinaryString(n));//10001
        /*
        判断第一个非零值是否位于高8位

            如果i之前就在24到30位之间，那上面的判断就不会执行。
            否则，i已经左移了16位，再右移24还是0，也就是说i是小于2^8的数字
            所以还是会加8,i再左移8位
         */
        if (i >>> 24 == 0) {
            n += 8;
            i <<= 8;
        }
        System.out.println(i);//268435456
        System.out.println(Integer.toBinaryString(i));//1 0000 0000 0000 0000 0000 0000 0000
        System.out.println(n);//17+ 8 = 25
        System.out.println(Integer.toBinaryString(n));//11001
        /*
            判断第一个非零值是否位于高4位
            如果i 在28 到30之间，那上面的也不会执行。
            同理，如果i >>> 28 == 0，i是小于2^4,i<15,所以这个没执行
         */
        if (i >>> 28 == 0) {
            n += 4;
            i <<= 4;
        }
        System.out.println(i);//268435456
        System.out.println(Integer.toBinaryString(i));//1 0000 0000 0000 0000 0000 0000 0000
        System.out.println(n);//25  没执行
        System.out.println(Integer.toBinaryString(n));//11001
        /*
            判断第一个非零值是否位于高2位

            上面没有左移动4位，还是左移； 16+8=24，因为16是1 0000，是个5位的，所以下面的执行了。
            i继续左移2位，
         */
        if (i >>> 30 == 0) {
            n += 2;
            i <<= 2;
        }
        System.out.println(i);//1073741824
        System.out.println(Integer.toBinaryString(i));//1000000000000000000000000000000
        System.out.println(n);//25 + 2 = 27
        System.out.println(Integer.toBinaryString(n));//11011
        /*
            判断第一个非零值是否位于左边第一位
         */
        n -= i >>> 31;
        System.out.println(i);//1073741824
        System.out.println(Integer.toBinaryString(i));//1000000000000000000000000000000
        System.out.println(n);//27
        System.out.println(Integer.toBinaryString(n));//11011

        System.out.println(n);//27
    }
}
