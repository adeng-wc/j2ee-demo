package com.adeng.patterns.behavioral.strategy.pay;

/**
 * 这样写的好处，用户只需要与PayType交互，不需要和具体的Payment实现类交互。
 *
 * 而且所有的支付方式都集中在这里，方便管理。
 */
public enum PayType {

    /**
     * 支付宝
     */
    ALI_PAY(new AliPay()),
    /**
     * 京东支付
     */
    JD_PAY(new JDPay());

    private final Payment pay;

    PayType(Payment pay) {
        this.pay = pay;
    }

    public Payment get() {
        return pay;
    }
}
