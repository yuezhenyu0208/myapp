package com.yue.myspp.dao;

import com.yue.myspp.entity.BlogContent;
import com.yue.myspp.entity.BlogContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogContentMapper {
    long countByExample(BlogContentExample example);

    int deleteByExample(BlogContentExample example);

    int deleteByPrimaryKey(Long cid);

    int insert(BlogContent record);

    int insertSelective(BlogContent record);

    List<BlogContent> selectByExampleWithBLOBs(BlogContentExample example);

    List<BlogContent> selectByExample(BlogContentExample example);

    BlogContent selectByPrimaryKey(Long cid);

    int updateByExampleSelective(@Param("record") BlogContent record, @Param("example") BlogContentExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogContent record, @Param("example") BlogContentExample example);

    int updateByExample(@Param("record") BlogContent record, @Param("example") BlogContentExample example);

    int updateByPrimaryKeySelective(BlogContent record);

    int updateByPrimaryKeyWithBLOBs(BlogContent record);

    int updateByPrimaryKey(BlogContent record);
}