package com.adeng.patterns.structural.decorator.upgrede;

import com.adeng.patterns.structural.decorator.old.ISigninService;
import com.adeng.patterns.structural.decorator.old.ResultMsg;

/**
 * 以下接口需要扩展。
 */
public interface ISigninForThirdService extends ISigninService {

    public ResultMsg loginForQQ(String openId);

    public ResultMsg loginForWechat(String openId);

    public ResultMsg loginForToken(String token);

    public ResultMsg loginForTelphone(String telphone,String code);

    public ResultMsg loginForRegist(String username,String password);

}
