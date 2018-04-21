package com.adeng.lombok.GetterSetter;

import lombok.Getter;

/**
 * @author
 * @create 2018-04-21 23:38
 */
public class GetterLazyExample {
    @Getter(lazy = true)
    private final double[] cached = expensive();

    private double[] expensive() {
        double[] result = new double[1000000];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.asin(i);
        }
        return result;
    }
}
