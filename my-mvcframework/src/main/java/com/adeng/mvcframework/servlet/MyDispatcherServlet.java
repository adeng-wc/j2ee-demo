package com.adeng.mvcframework.servlet;

import com.adeng.mvcframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 自定义HttpServlet
 *
 * @Author: Adengdeng
 * @Date: Create in 下午11:43 2018
 */
public class MyDispatcherServlet extends HttpServlet {

    /**
     * Web.xml 中的配置信息
     */
    private static final String CONFIG_INIT_PARAMETER = "contextConfigLocation";
    /**
     * 扫描的包路径
     */
    private static final String SCAN_PACKAGE = "scanPackage";

    /**
     * 主要的配置文件
     */
    private Properties contextConfig = new Properties();
    /**
     * 扫描出来的类
     */
    private List<String> classNames = new ArrayList<>();
    /**
     * 简单版本的IOC容器
     */
    private Map<String, Object> ioc = new HashMap<>();
    /**
     * 保存 url 和 Method
     */
    private Map<String, Method> handlerMapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doSispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception, Detail:" + Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * 分发请求
     *
     * @param req
     * @param resp
     */
    private void doSispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");

        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 Not Found!!!");
            return;
        }

        Method method = this.handlerMapping.get(url);
        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());


        //从reqest中拿到url传过来的参数
        Map<String, String[]> params = req.getParameterMap();

        //获取方法的形参列表
        Class<?>[] parameterTypes = method.getParameterTypes();
        Annotation[][] annotations = method.getParameterAnnotations();
        Object[] paramValues = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class parameterType = parameterTypes[i];
            //不能用instanceof，parameterType它不是实参，而是形参
            if (parameterType == HttpServletRequest.class) {
                paramValues[i] = req;
                continue;
            } else if (parameterType == HttpServletResponse.class) {
                paramValues[i] = resp;
                continue;
            } else if (parameterType == String.class) {

                Annotation[] as = annotations[i];

                for (Annotation a : as) {
                    if (a.annotationType() == MyRequestParam.class) {
                        MyRequestParam requestParam = (MyRequestParam) a;

                        for (Map.Entry<String, String[]> param : params.entrySet()) {
                            String value = Arrays.toString(param.getValue())
                                    .replaceAll("\\[|\\]", "")
                                    .replaceAll("\\s", ",");
                            paramValues[i] = value;
                        }
                    }
                }
            }
        }

        method.invoke(ioc.get(beanName), paramValues);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        /* 1. 读取配置文件 */
        doLoadConfig(config.getInitParameter(CONFIG_INIT_PARAMETER));

        /* 2. 扫描指定包路径下的类 */
        doScanner(contextConfig.getProperty(SCAN_PACKAGE));

        /* 3. 初始化扫描到的类，并放入到 IOC 容器中) */
        doInstance();

        /* 4. 依赖注入 */
        doAutowired();

        /* 5、建立URL和Method的映射关系(HandlerMapping) */
        doHandlerMapping();

        //输出一句话
        System.out.println(" MVC Framework 已经准备就绪啦!!");
    }

    /**
     * 加载配置文件
     * <p>
     * 直接从类路径下找到Spring主配置文件所在的路径
     * 并且将其读取出来放到 Properties 对象中
     *
     * @param initParameter
     */
    private void doLoadConfig(String initParameter) {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(initParameter)) {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫描出相关的类
     *
     * @param scanPackage
     */
    private void doScanner(String scanPackage) {
        // 将 .  转换成 \
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        assert url != null;
        File classPath = new File(url.getFile());
        for (File file : Objects.requireNonNull(classPath.listFiles())) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }

                classNames.add(scanPackage + "." + file.getName().replace(".class", ""));
            }
        }
    }

    /**
     * 初始化实例，并放入IOC容器中
     */
    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }

        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(MyController.class) || clazz.isAnnotationPresent(MyService.class)) {
                    Object instance = clazz.newInstance();
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName, instance);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 首字母，大写变小写
     *
     * @param simpleName
     * @return
     */
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        /*
            大小写字母的ASCII码相差32
            大小写字母的 ASCII 小于小写字母的 ASCII
            在Java中，对char做算学运算，实际上就是对 ASCII 码做算学运算
         */
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 实现自动注入
     */
    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            try {
                for (Field field : entry.getValue().getClass().getDeclaredFields()) {
                    if (!field.isAnnotationPresent(MyAutowired.class)) {
                        continue;
                    }

                    MyAutowired autowired = field.getAnnotation(MyAutowired.class);
                    String beanName = autowired.value().trim();
                    if ("".equals(beanName)) {
                        beanName = field.getType().getName();
                    }

                    field.setAccessible(true);
                    field.set(entry.getValue(), ioc.get(beanName));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据 Controller 生成映射
     */
    private void doHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(MyController.class)) {
                continue;
            }

            String baseUrl = "";
            if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                baseUrl = clazz.getAnnotation(MyRequestMapping.class).value();
            }

            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(MyRequestMapping.class)) {
                    continue;
                }

                String url = (baseUrl + "/" + method.getAnnotation(MyRequestMapping.class).value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);
            }
        }

    }


}
