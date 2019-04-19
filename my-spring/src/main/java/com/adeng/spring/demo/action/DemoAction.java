package com.adeng.spring.demo.action;

import com.adeng.spring.demo.service.HelloService;
import com.adeng.spring.framework.annotation.MyAutowired;
import com.adeng.spring.framework.annotation.MyController;
import com.adeng.spring.framework.annotation.MyRequestMapping;
import com.adeng.spring.framework.annotation.MyRequestParam;
import com.adeng.spring.framework.webmvc.servlet.MyModelAndView;

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

    @MyRequestMapping("/modelAndView")
    public MyModelAndView modelAndView(HttpServletRequest request, HttpServletResponse response, @MyRequestParam("name") String name) {
        return out(response, name);
    }

    private MyModelAndView out(HttpServletResponse response, String str) {
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
