package com.yue.myspp.dao.mapper.genetrator;

import com.yue.myspp.entity.SysTask;
import com.yue.myspp.entity.SysTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysTaskMapper {
    long countByExample(SysTaskExample example);

    int deleteByExample(SysTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysTask record);

    int insertSelective(SysTask record);

    List<SysTask> selectByExample(SysTaskExample example);

    SysTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysTask record, @Param("example") SysTaskExample example);

    int updateByExample(@Param("record") SysTask record, @Param("example") SysTaskExample example);

    int updateByPrimaryKeySelective(SysTask record);

    int updateByPrimaryKey(SysTask record);
}