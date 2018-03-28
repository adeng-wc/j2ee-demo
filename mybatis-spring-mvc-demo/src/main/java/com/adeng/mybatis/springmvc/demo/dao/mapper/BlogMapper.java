package com.adeng.mybatis.springmvc.demo.dao.mapper;

import com.adeng.mybatis.springmvc.demo.dao.model.Blog;
import com.adeng.mybatis.springmvc.demo.dao.model.BlogExample;
import com.adeng.mybatis.springmvc.demo.dao.model.Posts;
import com.adeng.mybatis.springmvc.demo.resultmap.BlogPostsResultMap;
import com.adeng.mybatis.springmvc.demo.resultmap.BlogResultMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    BlogResultMap selectBlogAuthor(Integer bid);

    List<Posts> selectByBlogId(Integer bid);

    BlogPostsResultMap selectBlogPosts2(Integer i);

    BlogPostsResultMap selectBlogPosts(Integer i);

    BlogResultMap selectBlogAuthor2(Integer i);
}