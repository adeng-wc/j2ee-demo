package com.adeng.guava.demo.base;


import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Optional null  感觉用起来不好用
 *
 * @author hzwengcheng 2018-05-20 22:31
 */
public class OptionalTest {

    @Test
    public void test1() {

//        Optional.of(null);
        Optional o1 = Optional.absent();
        Optional o11 = Optional.of(1);
        Optional o2 = Optional.fromNullable(null);

        System.out.println(o1.isPresent());
        System.out.println(o11.isPresent());
        System.out.println(o2.isPresent());

        System.out.println(Optional.fromNullable(null).or(2));
        System.out.println(Optional.fromNullable(1).or(2));
    }


}
