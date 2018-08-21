package com.yue.myspp.dao;

import com.yue.myspp.entity.CmsFile;
import com.yue.myspp.entity.CmsFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsFileMapper {
    long countByExample(CmsFileExample example);

    int deleteByExample(CmsFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsFile record);

    int insertSelective(CmsFile record);

    List<CmsFile> selectByExample(CmsFileExample example);

    CmsFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsFile record, @Param("example") CmsFileExample example);

    int updateByExample(@Param("record") CmsFile record, @Param("example") CmsFileExample example);

    int updateByPrimaryKeySelective(CmsFile record);

    int updateByPrimaryKey(CmsFile record);
}