package com.adeng.lombok.ToString;

import com.adeng.lombok.Shape;
import lombok.ToString;


/**
 * 通过 exclude 属性将字段排除，静态属性是不打印的
 *
 * @author
 * @create 2018-04-21 22:05
 */
@ToString(exclude = "id")
public class ToStringExample {
    private static final int STATIC_VAR = 10;
    private String name;
    private Shape shape = new Square(5, 10);
    private String[] tags;
    private int id = 1;

    public String getName() {
        return this.name;
    }

    @ToString(callSuper = true, includeFieldNames = true)
    public static class Square extends Shape {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public static void main(String[] args) {

        ToStringExample e = new ToStringExample();

        System.out.println(e.toString());

    }
}
