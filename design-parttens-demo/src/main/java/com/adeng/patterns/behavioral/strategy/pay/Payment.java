package com.adeng.patterns.behavioral.strategy.pay;

import com.adeng.patterns.behavioral.strategy.PayState;

/**
 * 支付渠道
 */
public interface Payment {

    public PayState pay(String uid, double amount);

}

