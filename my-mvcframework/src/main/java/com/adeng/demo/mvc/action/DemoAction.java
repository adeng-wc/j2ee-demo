package com.adeng.demo.mvc.action;

import com.adeng.demo.mvc.service.HelloService;
import com.adeng.framework.webmvc.annotation.MyAutowired;
import com.adeng.framework.webmvc.annotation.MyController;
import com.adeng.framework.webmvc.annotation.MyRequestMapping;
import com.adeng.framework.webmvc.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hzwengcheng 2019-03-29 11:36
 */
@MyController
@MyRequestMapping("/demo")
public class DemoAction {

    @MyAutowired
    private HelloService helloService;

    @MyRequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response, @MyRequestParam("name") String name) {
        try {
            response.getWriter().write("hello " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
