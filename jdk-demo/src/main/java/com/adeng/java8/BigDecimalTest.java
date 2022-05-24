package com.adeng.java8;

import java.math.BigDecimal;

/**
 * @author hzwengcheng 2018-05-24 16:47
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal(1.00);
        BigDecimal b = new BigDecimal(1.1000);

        System.out.println(a.compareTo(b));
    }
}
