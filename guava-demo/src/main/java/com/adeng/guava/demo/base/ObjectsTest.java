package com.adeng.guava.demo.base;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import org.junit.Test;

/**
 * 比较器
 *
 * @author hzwengcheng 2018-05-20 23:04
 */
public class ObjectsTest {

    @Test
    public void test1() {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.hashCode("a"));

        Person a = new Person();
        Person b = new Person();

        System.out.println(a.compareTo(b));
    }

    class Person implements Comparable<Person> {

        private String lastName;
        private String firstName;
        private Integer zipCode;

        @Override
        public int compareTo(Person that) {
            return ComparisonChain.start()
                    .compare(this.lastName, that.lastName, Ordering.natural().nullsLast())
                    .compare(this.firstName, that.firstName, Ordering.natural().nullsLast())
                    .compare(this.zipCode, that.zipCode, Ordering.natural().nullsLast())
                    .result();
        }
    }

}
