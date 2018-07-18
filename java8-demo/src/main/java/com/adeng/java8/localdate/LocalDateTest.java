package com.adeng.java8.localdate;

import java.text.ParseException;
import java.util.Random;

/**
 * @author hzwengcheng 2018-05-23 16:05
 */
public class LocalDateTest {

    public static void main(String[] args) throws ParseException {

//        Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp.toString());
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//        String dateSrr = df.format(new Date());
//        System.out.println(dateSrr);
//
//        Date date = df.parse(dateSrr);
//        System.out.println(date);
//
//        SimpleDateFormat df2 = new SimpleDateFormat("yyyy");
//        String dateSrr2 = df2.format(date);
//        System.out.println(dateSrr2);
//
//        SimpleDateFormat df3 = new SimpleDateFormat("yyyyMM");
//        String dateSrr3 = df3.format(date);
//        System.out.println(dateSrr3);
//
//        System.out.println(new Random().nextInt(3));

        Random random = new Random();

        System.out.println(random.nextInt(10000));

    }
}
