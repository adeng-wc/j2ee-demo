package com.adeng.mvcframework.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义HttpServlet
 *
 * @Author: Adengdeng
 * @Date: Create in 下午11:43 2018
 */
public class MvcDispatcherServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        /* 1. 读取配置文件 */
        String scanPackage = config.getInitParameter("scanPackage");

        /* 2. 扫描指定包路径下的类 */
        scanClass(scanPackage);

        /* 3. 把扫描出来的类进行实例化(BeanFactroy) */
        instance();

        /* 4. 依赖注入*/
        autowired();

        /* 5、建立URL和Method的映射关系(HandlerMapping) */
        handlerMapping();

        //输出一句话
        System.out.println(" MVC Framework 已经准备就绪啦!!");

    }

    private void handlerMapping() {


    }

    private void autowired() {

    }

    private void scanClass(String scanPackage) {

    }

    private void instance() {

    }

}
