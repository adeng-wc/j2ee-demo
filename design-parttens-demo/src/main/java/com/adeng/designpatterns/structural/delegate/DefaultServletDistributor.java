package com.adeng.designpatterns.structural.delegate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultServletDistributor extends HttpServlet {

    private Map<String, ControllerHandler> map = new ConcurrentHashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //初始化Map，将所有的处理器都纳入Map中

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //分发请求，委派给Controller处理
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {

        String url = req.getRequestURI();

        //根据请求找到对应的处理对象 ControllerHandler


        //然后将请求分发给对应的ControllerHandler

    }

    static class ControllerHandler {

        private Object controller;
        private Method method;
        private String url;


        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
