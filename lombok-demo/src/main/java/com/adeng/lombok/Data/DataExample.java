package com.adeng.lombok.Data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

/**
 * @author
 * @create 2018-04-21 22:44
 */
@Data
public class DataExample {

    private final String name;
    @Setter(AccessLevel.PACKAGE)
    private int age;
    private double score;
    private String[] tags;

    @ToString(includeFieldNames = true)
    @Data(staticConstructor = "of")
    public static class Exercise<T> {
        private final String name;
        private final T value;
    }

    public static void main(String[] args) {

        DataExample d = new DataExample("hello");

        System.out.println(d.getName());
        System.out.println(d.toString());
        System.out.println(d.hashCode());


        Exercise e = Exercise.of("name2","value");

        System.out.println(e.toString());
    }
}
