package com.adeng.patterns.behavioral.strategy;

/**
 * 订单支付完成后的状态
 */
public class PayState {

    private int code; // 1 支付成功， 0 未成功
    private Object data;
    private String msg;

    public PayState(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String toString(){
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }

}
