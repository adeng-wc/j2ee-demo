package com.adeng.patterns.structural.adapter;

/**
 * 这里是通过继承的方式将两个组合起来使用，也可以使用实现两个不同的接口。
 * 或者通过组合的方式，达到拥有额外功能的作用。
 *
 *
 * 将一个类的接口转为成客户希望的另外一个接口。
 * Adapter模式使得原本由于接口不兼容而不能一起工作的类可以一起工作。
 */
public class SiginForThirdService extends SiginService{

    /**
     * 通过适配器，实现 QQ 账号登陆
     *
     * @param openId
     * @return
     */
    public ResultMsg loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法

        return loginForRegist(openId,null);
    }

    private ResultMsg loginForRegist(String username, Object o) {
        super.regist(username,null);
        return super.login(username,null);
    }
}
