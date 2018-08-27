package com.yue.myspp.dao.mapper.genetrator;

import com.yue.myspp.entity.SsShadowsock;
import com.yue.myspp.entity.SsShadowsockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsShadowsockMapper {
    long countByExample(SsShadowsockExample example);

    int deleteByExample(SsShadowsockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SsShadowsock record);

    int insertSelective(SsShadowsock record);

    List<SsShadowsock> selectByExample(SsShadowsockExample example);

    SsShadowsock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SsShadowsock record, @Param("example") SsShadowsockExample example);

    int updateByExample(@Param("record") SsShadowsock record, @Param("example") SsShadowsockExample example);

    int updateByPrimaryKeySelective(SsShadowsock record);

    int updateByPrimaryKey(SsShadowsock record);
}