package com.yue.myspp.dao;

import com.yue.myspp.entity.SysUserPlus;
import com.yue.myspp.entity.SysUserPlusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserPlusMapper {
    long countByExample(SysUserPlusExample example);

    int deleteByExample(SysUserPlusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserPlus record);

    int insertSelective(SysUserPlus record);

    List<SysUserPlus> selectByExample(SysUserPlusExample example);

    SysUserPlus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserPlus record, @Param("example") SysUserPlusExample example);

    int updateByExample(@Param("record") SysUserPlus record, @Param("example") SysUserPlusExample example);

    int updateByPrimaryKeySelective(SysUserPlus record);

    int updateByPrimaryKey(SysUserPlus record);
}