package com.yue.myspp.service;

import com.yue.myspp.dao.SysUserMapper;
import com.yue.myspp.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    SysUserMapper sysUserMapper;

    public SysUser findUserByName(){
        return sysUserMapper.selectByPrimaryKey(1L);
    }
}
