package com.adeng.customize.mybatis.core.config;

import com.adeng.customize.mybatis.core.annotation.*;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 作用是找到mapper.xml或者使用注解找到mapper对应的配置
 * Created by w11282 on 2018/4/3.
 */
public class Configuration {

    /**
     * 保存解析后的Mapper
     */
    private MapperRegistory mapperRegistory = new MapperRegistory();

    /**
     * key 是mapper方法的全路径名称，value是sql操作的类型
     */
    private Map<String, SqlCommondType> mapperMethodMap = new HashMap<>();

    private String scanPath;

    public Configuration(String scanPath) {
        this.scanPath = scanPath;
    }

    public Map<String, SqlCommondType> getMapperMethodMap() {
        return mapperMethodMap;
    }

    public MapperRegistory getMapperRegistory() {
        return mapperRegistory;
    }

    public void build() throws IOException, ClassNotFoundException {

        String path = scanPath.replace(".", "/");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        List<File> dirs = new ArrayList<>();
        Enumeration<URL> resources = classLoader.getResources(path);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        for (File f : dirs) {
            findClass(f, scanPath);
        }
    }

    private Collection<? extends Class> findClass(File f, String packageName) throws ClassNotFoundException {

        List<Class> classes = new ArrayList<>();

        if (!f.exists()) {
            return classes;
        }

        File[] files = f.listFiles();

        for (File file : files) {

            if (file.isDirectory()) {

                classes.addAll(findClass(file, packageName + "." + file.getName()));

            } else if (file.getName().endsWith(".class")) {

                String newPath = packageName + "." + file.getName();

                Class c = Class.forName(newPath.substring(0, newPath.length() - 6));

                //添加mapper与entiry的对应关系
                Annotation entity = c.getAnnotation(Entiry.class);
                Class obj = ((Entiry) entity).value();
                mapperRegistory.registor(c.getName(), obj);

                //添加mapperMethod 和SQL类型
                Method[] methods = c.getMethods();
                for (Method method : methods) {
                    String methodPath = newPath.substring(0, newPath.length() - 6) + "." + method.getName();

                    if (method.getAnnotation(Select.class) != null) {
                        mapperMethodMap.put(methodPath, SqlCommondType.SELECT);
                    } else if (method.getAnnotation(Delete.class) != null) {
                        mapperMethodMap.put(methodPath, SqlCommondType.DELETE);
                    } else if (method.getAnnotation(Update.class) != null) {
                        mapperMethodMap.put(methodPath, SqlCommondType.UPDATE);
                    }else if (method.getAnnotation(Insert.class) != null) {
                        mapperMethodMap.put(methodPath, SqlCommondType.Insert);
                    }
                }
            }
        }

        return classes;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String packageName = "com.adeng.customize.mybatis.mapper";
        String path = packageName.replace(".", "/");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        List<File> dirs = new ArrayList<>();
        Enumeration<URL> resources = classLoader.getResources(path);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

    }
}
