package com.adeng.designpatterns.strategy.pay;

/**
 * 这样写的好处，用户只需要与PayType交互，不需要和具体的Payment实现类交互。
 *
 * 而且所有的支付方式都集中在这里，方便管理。
 */
public enum PayType {

    ALI_PAY(new AliPay()),
    JD_PAY(new JDPay());

    private final Payment pay;

    PayType(Payment pay) {
        this.pay = pay;
    }

    public Payment get() {
        return pay;
    }
}
