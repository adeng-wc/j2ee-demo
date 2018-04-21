package com.adeng.lombok.GetterSetter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author
 * @create 2018-04-21 21:58
 */
public class GetterSetterExample {
    /**
     * Age of the person. Water is wet.
     *
     * @param age New value for this person's age. Sky is blue.
     * @return The current value of this person's age. Circles are round.
     */
    @Getter
    @Setter
    private int age = 10;

    /**
     * Name of the person.
     * -- SETTER --
     * Changes the name of this person.
     *
     * @param name The new value.
     */
    @Setter(AccessLevel.PROTECTED)
    private String name;

    @Override
    public String toString() {
        return String.format("%s (age: %d)", name, age);
    }


    public static void main(String[] args) {
        GetterSetterExample e = new GetterSetterExample();

        e.setName("hello");

    }
}