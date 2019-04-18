package com.adeng.spring.framework.beans.support;

import com.adeng.spring.framework.beans.config.MyBeanDefinition;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * @author hzwengcheng 2019-04-18 11:20
 */
@NoArgsConstructor
public class MyBeanDefinitionReader {

    private List<String> registyBeanClasses = new ArrayList<>();
    private Properties config = new Properties();
    /**
     * 固定配置文件中的Key，相当于XML的规范
     */
    private final String SCAN_PACKAGE = "scanPackage";

    public MyBeanDefinitionReader(String... locations) {
        // 通过URL定位找到其所对应的文件，然后转换成文件流
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(locations[0].replace("classpath:", ""));
        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 扫描
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String scanPackage) {
        // 将 .  转换成 \
        URL url = this.getClass().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        assert url != null;
        File classPath = new File(url.getFile());
        for (File file : Objects.requireNonNull(classPath.listFiles())) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }

                String className = scanPackage + "." + file.getName().replace(".class", "");
                registyBeanClasses.add(className);
            }
        }
    }

    public Properties getConfig() {
        return this.config;
    }

    /**
     * 将扫描到的信息转换成 MyBeanDefinition
     *
     * @return
     */
    public List<MyBeanDefinition> loadBeanDefinitions() {
        List<MyBeanDefinition> result = new ArrayList<>();
        for (String className : registyBeanClasses) {
            MyBeanDefinition beanDefinition = doCreateMyBeanDefinition(className);
            if (beanDefinition == null) {
                continue;
            }
            result.add(beanDefinition);
        }
        return result;
    }

    /**
     * 将 className 变成 BeanDefinition
     *
     * @param className
     * @return
     */
    private MyBeanDefinition doCreateMyBeanDefinition(String className) {
        try {
            Class<?> beanClass = Class.forName(className);
            // 有可能是接口，需要它的实现类作为 beanClassName
            if (!beanClass.isInterface()) {
                MyBeanDefinition beanDefinition = new MyBeanDefinition();
                beanDefinition.setFactoryBeanName(toLowerFirstCase(beanClass.getSimpleName()));
                beanDefinition.setBeanClassName(className);
                return beanDefinition;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
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
}
