package com.adeng.patterns.structural.adapter;

public class SiginService {

    /**
     * 注册方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200, "regist 成功", new User());
    }


    /**
     * 登录的方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password) {
        return new ResultMsg(200, "login 成功", new User());
    }

}
