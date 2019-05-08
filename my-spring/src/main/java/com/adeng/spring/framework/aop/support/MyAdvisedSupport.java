package com.adeng.spring.framework.aop.support;

import com.adeng.spring.framework.aop.aspect.MyMethodAfterAdviceInterceptor;
import com.adeng.spring.framework.aop.aspect.MyMethodAfterThrowAdviceInterceptor;
import com.adeng.spring.framework.aop.aspect.MyMethodBeforeAdviceInterceptor;
import com.adeng.spring.framework.aop.config.MyAopConfig;
import lombok.Data;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hzwengcheng 2019-04-26 10:39
 */
@Data
public class MyAdvisedSupport {

    private Class<?> targetClass;
    private Object target;
    private MyAopConfig config;
    private Pattern pointCutClassPattern;

    private Map<Method, List<Object>> methodCache;

    public MyAdvisedSupport(MyAopConfig config) {
        this.config = config;
    }

    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method, Class<?> targetClass) throws Exception {
        List<Object> cached = this.methodCache.get(method);
        if (cached == null) {
            Method m = targetClass.getMethod(method.getName(), method.getParameterTypes());
            this.methodCache.put(m, cached);
        }
        return cached;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
        try {
            parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parse() throws Exception {
        String pointCut = config.getPointCut()
                .replaceAll("\\.", "\\\\.")
                .replaceAll("\\\\.\\*", ".*")
                .replaceAll("\\(", "\\\\(")
                .replaceAll("\\)", "\\\\)");

        // public .* com.adeng.spring.demo.service..*Service..*
        // 正则
        String pointCutForClassRegx = pointCut.substring(0, pointCut.lastIndexOf("\\(") - 4);

        pointCutClassPattern = Pattern.compile("class" +
                pointCutForClassRegx.substring(pointCutForClassRegx.lastIndexOf(" ") + 1));

        methodCache = new HashMap<>(16);

        Pattern pattern = Pattern.compile(pointCut);
        Class aspectClass = Class.forName(this.config.getAspectClass());
        Map<String, Method> aspectMehtods = new HashMap<>(16);
        for (Method method : aspectClass.getMethods()) {
            aspectMehtods.put(method.getName(), method);
        }

        for (Method m : this.targetClass.getMethods()) {
            String methodString = m.toString();
            if (methodString.contains("throws")) {
                methodString = methodString.substring(0, methodString.lastIndexOf("methodString")).trim();
            }

            Matcher matcher = pattern.matcher(methodString);
            if (matcher.matches()) {
                // 执行器链
                List<Object> advices = new LinkedList<>();
                // 把每一个方法包装成 MethodInterceptor
                if (!(null == config.getAspectBefore() || "".equals(config.getAspectBefore()))) {
                    // 创建一个 Advice
                    advices.add(new MyMethodBeforeAdviceInterceptor(
                            aspectMehtods.get(config.getAspectBefore()), aspectClass.newInstance()));
                }

                if (!(null == config.getAspectAfter() || "".equals(config.getAspectAfter()))) {
                    // 创建一个 Advice
                    advices.add(new MyMethodAfterAdviceInterceptor(
                            aspectMehtods.get(config.getAspectAfter()), aspectClass.newInstance()));
                }

                if (!(null == config.getAspectAfterThrow() || "".equals(config.getAspectAfterThrow()))) {
                    // 创建一个 Advice
                    MyMethodAfterThrowAdviceInterceptor afterThrowAdvice =
                            new MyMethodAfterThrowAdviceInterceptor(
                                    aspectMehtods.get(config.getAspectAfterThrow()), aspectClass.newInstance());
                    afterThrowAdvice.setThrowName(config.getAspectAfterThrowName());
                    advices.add(afterThrowAdvice);
                }
                methodCache.put(m, advices);
            }
        }

    }

    public boolean pointCutMatch() {
        return pointCutClassPattern.matcher(this.targetClass.toString()).matches();
    }
}
