package com.adeng.designpatterns.behavioral.strategy.pay;

import com.adeng.designpatterns.behavioral.strategy.PayState;

/**
 * 支付渠道
 */
public interface Payment {

    public PayState pay(String uid, double amount);

}

