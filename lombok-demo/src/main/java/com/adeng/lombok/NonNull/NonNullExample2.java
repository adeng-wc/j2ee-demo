package com.adeng.lombok.NonNull;

import lombok.NonNull;

/**
 * @author
 * @create 2018-04-21 21:41
 */
public class NonNullExample2  {
    private String name;

    public NonNullExample2(@NonNull String person) {

        if (person == null) {
            throw new MyException("person");
        }
        this.name = person.toString();
    }


    public static void main(String[] args) {

        NonNullExample2 nullExample = new NonNullExample2(null);

        NonNullExample2 nullExample2 = new NonNullExample2("");

    }
}