package com.adeng.lombok.NonNull;

/**
 * @author
 * @create 2018-04-21 21:43
 */
public class MyException extends RuntimeException {

    public MyException(String person) {

        super(person);
    }
}
