package com.adeng.spring.framework.webmvc.servlet;

import lombok.Data;

import java.util.Map;

/**
 * @author hzwengcheng 2019-04-19 10:32
 */
@Data
public class MyModelAndView {

    private String viewName;
    private Map<String, ?> model;

    public MyModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public MyModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }
}
