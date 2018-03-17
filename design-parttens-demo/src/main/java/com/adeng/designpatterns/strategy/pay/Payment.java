package com.adeng.designpatterns.strategy.pay;

import com.adeng.designpatterns.strategy.PayState;

/**
 * 支付渠道
 */
public interface Payment {

    public PayState pay(String uid, double amount);

}

