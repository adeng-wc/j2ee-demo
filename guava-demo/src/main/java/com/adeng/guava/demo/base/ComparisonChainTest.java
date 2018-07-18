package com.adeng.guava.demo.base;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import org.junit.Test;

/**
 * 比较器
 *
 * @author hzwengcheng 2018-05-20 23:04
 */
public class ComparisonChainTest {

    @Test
    public void test1() {

    }

    class Person implements Comparable<Person> {
        private String lastName;
        private String firstName;
        private int zipCode;

        @Override
        public int compareTo(Person that) {
            return ComparisonChain.start()
                    .compare(this.lastName, that.lastName)
                    .compare(this.firstName, that.firstName)
                    .compare(this.zipCode, that.zipCode, Ordering.natural().nullsLast())
                    .result();
        }

    }

}
