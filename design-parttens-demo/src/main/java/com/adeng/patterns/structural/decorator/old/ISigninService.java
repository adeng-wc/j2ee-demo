package com.adeng.patterns.structural.decorator.old;

public interface ISigninService {

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    ResultMsg regist(String username, String password);


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    ResultMsg login(String username, String password);

}
