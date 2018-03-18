package com.adeng.designpatterns.structural.decorator.upgrede;

import com.adeng.designpatterns.structural.decorator.old.ISigninService;
import com.adeng.designpatterns.structural.decorator.old.ResultMsg;

public class SigninForThirdService implements ISigninForThirdService {

    private final ISigninService service;

    /**
     * 装饰者模式，利用传入的原有对象来调用原有方法
     * @param service
     */
    public SigninForThirdService(ISigninService service){
        this.service = service;
    }


    @Override
    public ResultMsg regist(String username, String password) {
        return service.regist(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return service.login(username,password);
    }


    public ResultMsg loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法

        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后再重新登陆了一次
        return  null;
    }

    public ResultMsg loginForTelphone(String telphone,String code){

        return null;
    }

    public ResultMsg loginForRegist(String username,String password){
        this.regist(username,null);
        return this.login(username,null);
    }

}
