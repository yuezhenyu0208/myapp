package com.yue.myspp.dao.mapper.extended;

import com.yue.myspp.dao.mapper.genetrator.SysUserMapper;
import com.yue.myspp.entity.SysUser;
import com.yue.myspp.entity.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserExtendedMapper extends  SysUserMapper {
    int updateByPrimaryKey1(SysUser record);
}