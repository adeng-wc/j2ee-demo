package com.adeng.spring.framework.webmvc.servlet;

import lombok.Data;

import java.io.File;
import java.util.Locale;

/**
 * @author hzwengcheng 2019-04-19 11:16
 */
@Data
public class MyViewResolver {


    private final String DEFAULT_TEMPLATE_SUFFX = ".html";
    private File templateRootDir;

    public MyViewResolver(String templateRoot) {
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        this.templateRootDir = new File(templateRootPath);

    }

    public MyView resolveViewName(String viewName, Locale locale) throws Exception {
        if (null == viewName || "".equals(viewName.trim())) {
            return null;
        }
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFX);
        File templateFile = new File((templateRootDir.getPath() + "/" + viewName).replaceAll("/+", "/"));
        return new MyView(templateFile);
    }
}
