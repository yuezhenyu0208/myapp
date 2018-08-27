package com.yue.myspp.service;

import com.yue.myspp.common.MD5Util;
import com.yue.myspp.common.R;
import com.yue.myspp.dao.mapper.genetrator.SysUserMapper;
import com.yue.myspp.entity.SsShadowsock;
import com.yue.myspp.entity.SysUser;
import com.yue.myspp.entity.SysUserExample;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserService {

    @Autowired
    SysUserMapper sysUserMapper;

    public SysUser findUserByName(String username){
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username);
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }else{
            return list.get(0);
        }
    }
    public R regist(String username,String pasword){
        SysUser sysUser = findUserByName(username);
        if(sysUser!=null){
            R.result(103,"用户名已存在");
        }
        sysUser = new SysUser();
        sysUser.setUsername(username);
        pasword = MD5Util.encrypt(username,pasword);
        sysUser.setPassword(pasword);
        sysUserMapper.insert(sysUser);
        return R.OK();
    }

    public SysUser findSysUserByWeId(String weId){
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andWeIdEqualTo(weId);
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

}
