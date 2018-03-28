package com.adeng.mybatis.springmvc.demo.resultmap;

import com.adeng.mybatis.springmvc.demo.dao.model.Posts;
import lombok.Data;

import java.util.List;

/**
 * Created by James
 * From 咕泡学院出品
 * 老师咨询 QQ 2904270631
 */
@Data
public class BlogPostsResultMap{

    private Integer bid;

    private String name;

    private Integer authorId;

    private List<Posts> posts;

}
