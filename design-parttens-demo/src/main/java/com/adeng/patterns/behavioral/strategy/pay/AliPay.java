package com.adeng.patterns.behavioral.strategy.pay;

import com.adeng.patterns.behavioral.strategy.PayState;

public class AliPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("Ali 支付成功");
        return new PayState(1, amount, "支付成功");
    }
}
