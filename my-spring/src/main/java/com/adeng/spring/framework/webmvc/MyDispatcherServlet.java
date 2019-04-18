package com.adeng.spring.framework.webmvc;

import com.adeng.spring.framework.context.MyApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * request 请求的分发。由容器启动加载。
 *
 * @author hzwengcheng 2019-04-17 16:55
 */
public class MyDispatcherServlet extends HttpServlet {

    /**
     * Web.xml 中的配置信息
     */
    private static final String CONFIG_INIT_PARAMETER = "location";

    private MyApplicationContext applicationContext;

    /** List of HandlerMappings used by this servlet */
    private List<MyHandlerMapping> handlerMappings;

    /** List of HandlerAdapters used by this servlet */
    private List<MyHandlerAdapter> handlerAdapters;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        //1、读取配置文件，获取配置信息

        //2、初始化
        this.applicationContext = initWebApplicationContext(config);

        //3、容器初始化完成后要触发 初始化 servlet 九大组件的流程

        onRefresh(this.applicationContext);
    }

    /**
     * 创建 ApplicationContext
     *
     * @return
     * @param config
     */
    private MyApplicationContext initWebApplicationContext(ServletConfig config) {
        MyApplicationContext context = new MyApplicationContext();
//        context.setConfigLocations(config.getInitParameter(CONFIG_INIT_PARAMETER));
        context.refresh();
        return context;
    }

    private void onRefresh(MyApplicationContext context) {
        initStrategies(context);
    }

    private void initStrategies(MyApplicationContext context) {
//        //多文件上传的组件
//        initMultipartResolver(context);
//        //初始化本地语言环境
//        initLocaleResolver(context);
//        //初始化模板处理器
//        initThemeResolver(context);
        //handlerMapping
        initHandlerMappings(context);
        //初始化参数适配器
        initHandlerAdapters(context);
//        //初始化异常拦截器
//        initHandlerExceptionResolvers(context);
//        //初始化视图预处理器
//        initRequestToViewNameTranslator(context);
        //初始化视图转换器
        initViewResolvers(context);
//        //初始化缓存
//        initFlashMapManager(context);
    }

    private void initViewResolvers(MyApplicationContext context) {

    }

    private void initHandlerAdapters(MyApplicationContext context) {

    }

    /**
     * 初始化 HandlerMapping
     *
     * @param context
     */
    private void initHandlerMappings(MyApplicationContext context) {

    }
}
