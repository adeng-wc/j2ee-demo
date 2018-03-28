package com.adeng.mybatis.springmvc.demo.dao;

import com.adeng.mybatis.springmvc.demo.BaseTest;
import com.adeng.mybatis.springmvc.demo.dao.mapper.BlogMapper;
import com.adeng.mybatis.springmvc.demo.dao.model.Posts;
import com.adeng.mybatis.springmvc.demo.resultmap.BlogPostsResultMap;
import com.adeng.mybatis.springmvc.demo.resultmap.BlogResultMap;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author
 * @create 2018-03-28 下午11:55
 */
public class BlogMapperTest extends BaseTest {


    private final static Logger log = LoggerFactory.getLogger(BlogMapperTest.class);

    @Autowired
    private BlogMapper mapper;

    @Test
    public void selectBlogAuthor() {//one to one 嵌套结果
        BlogResultMap resultMap = mapper.selectBlogAuthor(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectByBlogId() {
        List<Posts> resultMap = mapper.selectByBlogId(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectBlogPosts嵌套结果() {//one to many 嵌套结果
        BlogPostsResultMap resultMap = mapper.selectBlogPosts2(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectBlogPosts嵌套查询() throws InterruptedException {//one to many 嵌套查询
        BlogPostsResultMap resultMap = mapper.selectBlogPosts(1);
        System.out.println(resultMap.getName());
        Thread.sleep(5000);
        System.out.println(resultMap.getPosts().get(0).getBlogId());
    }

    @Test
    public void selectByAuthorId嵌套查询() {//one to one 嵌套查询
        BlogResultMap resultMap = mapper.selectBlogAuthor(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectByAuthorId2() {//one to one 嵌套结果
        BlogResultMap resultMap = mapper.selectBlogAuthor2(1);
        System.out.println(resultMap);
    }

}
