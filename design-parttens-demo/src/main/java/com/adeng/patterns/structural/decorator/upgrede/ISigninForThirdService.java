package com.adeng.patterns.structural.decorator.upgrede;

import com.adeng.patterns.structural.decorator.old.ISigninService;
import com.adeng.patterns.structural.decorator.old.ResultMsg;

/**
 * 以下接口需要扩展。
 */
public interface ISigninForThirdService extends ISigninService {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String telphone, String code);

    ResultMsg loginForRegist(String username, String password);

}
