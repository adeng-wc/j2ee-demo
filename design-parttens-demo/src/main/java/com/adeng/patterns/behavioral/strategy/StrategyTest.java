package com.adeng.patterns.behavioral.strategy;

import com.adeng.patterns.behavioral.strategy.pay.PayType;

/**
 * 策略模式，选择不同的策略解决相同的事情。
 *
 * 和命令模式不同点，命令模式是对不同的命令，做不同的事情。
 */
public class StrategyTest {

    public static void main(String[] args) {

        Order order = new Order("1","20180311001000009",324.45);

        order.pay(PayType.ALI_PAY);

    }
}
