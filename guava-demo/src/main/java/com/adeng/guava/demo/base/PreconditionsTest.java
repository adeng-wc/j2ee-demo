package com.adeng.guava.demo.base;

import org.junit.Test;

import static com.google.common.base.Preconditions.*;

/**
 * 前置条件
 *
 * @author hzwengcheng 2018-05-20 22:51
 */
public class PreconditionsTest {


    @Test
    public void test1() {

        int i = 1;
        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);

        Integer integer = checkNotNull(i, "check is Null");

        checkState(true);

        int index = 5, size = 10;

        checkElementIndex(index, size);

        checkPositionIndex(index, size);


    }


}
