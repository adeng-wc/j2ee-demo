package com.adeng.lombok.ArgsConstructor;

import lombok.*;

/**
 * @author
 * @create 2018-04-21 22:29
 */
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ConstructorExample<T> {

    private int x, y;

    @NonNull
    private T description;

    @NoArgsConstructor
    @ToString
    public static class NoArgsExample {
        @NonNull
        private String field;
    }


    public static void main(String[] args) {

        ConstructorExample c = new ConstructorExample(1, 2, new NoArgsExample());

        System.out.println(c.toString());

        //因为T description 不为空
        ConstructorExample<NoArgsExample> of = ConstructorExample.of(new NoArgsExample());



    }
}
