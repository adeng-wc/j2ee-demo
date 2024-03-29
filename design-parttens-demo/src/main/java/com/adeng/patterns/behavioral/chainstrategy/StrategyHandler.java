package com.adeng.patterns.behavioral.chainstrategy;

/**
 * @author wengcheng on 2021/1/26
 */
public interface StrategyHandler<T, R> {

    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     *
     * @param param
     * @return
     */
    R apply(T param);
}
