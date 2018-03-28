package com.adeng.mybatis.springmvc.demo.resultmap;

import com.adeng.mybatis.springmvc.demo.dao.model.Author;
import lombok.Data;

/**
 * Created by James
 * From 咕泡学院出品
 * 老师咨询 QQ 2904270631
 */
@Data
public class BlogResultMap {

    private Integer bid;

    private String name;

    private Author author;
}
