package com.adeng.spring.framework.webmvc.servlet;

import com.adeng.spring.framework.annotation.MyController;
import com.adeng.spring.framework.annotation.MyRequestMapping;
import com.adeng.spring.framework.context.MyApplicationContext;
import lombok.extern.java.Log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * request 请求的分发。由容器启动加载。
 *
 * @author hzwengcheng 2019-04-17 16:55
 */
@Log
public class MyDispatcherServlet extends HttpServlet {

    /**
     * Web.xml 中的配置信息
     */
    private static final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";
    private static final String TEMPLATE_ROOT = "templateRoot";

    private MyApplicationContext applicationContext;

    /**
     * List of HandlerMappings used by this servlet
     */
    private List<MyHandlerMapping> handlerMappings = new ArrayList<>();

    /**
     * List of HandlerAdapters used by this servlet
     */
    private Map<MyHandlerMapping, MyHandlerAdapter> handlerAdapters = new HashMap<>();

    private List<MyViewResolver> viewResolvers = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.doDispatcher(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                processDispatchResult(req, resp, new MyModelAndView("500"));
            } catch (Exception ex) {
                ex.printStackTrace();
                resp.getWriter().write("500 Exception, Detail:" + Arrays.toString(e.getStackTrace()));
            }
        }
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1. 通过从request中拿到url，取匹配一个handlermaping
        MyHandlerMapping handler = getHandler(req);

        // return 404
        if (handler == null) {
            processDispatchResult(req, resp, new MyModelAndView("404"));
            return;
        }

        //2. 准备调用前的参数
        MyHandlerAdapter ha = getHandlerAdapter(handler);

        //3. 真正的调用方法
        MyModelAndView mv = ha.handle(req, resp, handler);

        //4. 真正的输出
        processDispatchResult(req, resp, mv);
    }

    /**
     * 把给我的ModeANDView变成HTML，Outputstream......
     *
     * @param req
     * @param resp
     * @param mv
     */
    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, MyModelAndView mv) throws Exception {
        if (null == mv || this.viewResolvers.isEmpty()) {
            return;
        }

        for (MyViewResolver viewResolver : this.viewResolvers) {
            MyView view = viewResolver.resolveViewName(mv.getViewName(), null);
            view.render(mv.getModel(), req, resp);
        }
    }

    private MyHandlerAdapter getHandlerAdapter(MyHandlerMapping handlerMapping) {
        return this.handlerAdapters.get(handlerMapping);
    }

    /**
     * 通过 request 查找对应的 MyHandlerMapping
     *
     * @param req
     * @return
     */
    private MyHandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMappings.isEmpty()) {
            return null;
        }
        //绝对路径
        String url = req.getRequestURI();
        //处理成相对路径
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");

        for (MyHandlerMapping handler : this.handlerMappings) {
            Matcher matcher = handler.getPattern().matcher(url);
            if (!matcher.matches()) {
                continue;
            }
            return handler;
        }
        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、初始化 ApplicationContext
        this.applicationContext = new MyApplicationContext(config.getInitParameter(CONTEXT_CONFIG_LOCATION));

        //2、初始化 Spring MVC 九大组件的流程
        onRefresh(this.applicationContext);
    }

    private void onRefresh(MyApplicationContext context) {
        initStrategies(context);
    }

    /**
     * 初始化策略
     *
     * @param context
     */
    private void initStrategies(MyApplicationContext context) {
        //多文件上传的组件
        initMultipartResolver(context);
        //初始化本地语言环境
        initLocaleResolver(context);
        //初始化模板处理器
        initThemeResolver(context);
        //handlerMapping
        initHandlerMappings(context);
        //初始化参数适配器
        initHandlerAdapters(context);
        //初始化异常拦截器
        initHandlerExceptionResolvers(context);
        //初始化视图预处理器
        initRequestToViewNameTranslator(context);
        //初始化视图转换器
        initViewResolvers(context);
        //初始化缓存
        initFlashMapManager(context);
    }

    private void initFlashMapManager(MyApplicationContext context) {

    }

    private void initRequestToViewNameTranslator(MyApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(MyApplicationContext context) {

    }

    private void initThemeResolver(MyApplicationContext context) {

    }

    private void initLocaleResolver(MyApplicationContext context) {
    }

    private void initMultipartResolver(MyApplicationContext context) {
    }

    /**
     * ViewResolvers
     *
     * @param context
     */
    private void initViewResolvers(MyApplicationContext context) {
        //拿到模板的存放目录
        String templateRoot = context.getConfig().getProperty(TEMPLATE_ROOT);
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File templateRootDir = new File(templateRootPath);
        for (File template : templateRootDir.listFiles()) {
            this.viewResolvers.add(new MyViewResolver(templateRoot));
        }
    }


    /**
     * 初始化 HandlerAdapters
     * <p>
     * 把一个request请求变成一个Handler，参数都是字符串，自动匹配到Handler中的形参
     *
     * @param context
     */
    private void initHandlerAdapters(MyApplicationContext context) {
        for (MyHandlerMapping handlerMapping : this.handlerMappings) {
            this.handlerAdapters.put(handlerMapping, new MyHandlerAdapter());
        }
    }

    /**
     * 初始化 HandlerMapping
     *
     * @param context
     */
    private void initHandlerMappings(MyApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        try {
            for (String beanName : beanNames) {
                Object controller = context.getBean(beanName);

                Class<?> clazz = controller.getClass();
                if (!clazz.isAnnotationPresent(MyController.class)) {
                    continue;
                }

                String baseUrl = "";
                if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                    baseUrl = clazz.getAnnotation(MyRequestMapping.class).value();
                }

                // 获取 Method 的url 配置
                for (Method method : clazz.getMethods()) {
                    if (!method.isAnnotationPresent(MyRequestMapping.class)) {
                        continue;
                    }

                    MyRequestMapping requestMapping = method.getAnnotation(MyRequestMapping.class);
                    String regex = ("/" + baseUrl + "/" + requestMapping.value())
                            .replaceAll("\\*", ".*")
                            .replaceAll("/+", "/");
                    Pattern pattern = Pattern.compile(regex);
                    MyHandlerMapping handlerMapping = new MyHandlerMapping(pattern, controller, method);
                    this.handlerMappings.add(handlerMapping);
                    log.info(handlerMapping.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
