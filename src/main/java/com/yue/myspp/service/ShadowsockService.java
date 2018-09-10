package com.yue.myspp.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yue.myspp.common.PageUtil;
import com.yue.myspp.common.R;
import com.yue.myspp.common.util.CreateJSONFileUtil;
import com.yue.myspp.common.util.ShellUtil;
import com.yue.myspp.dao.mapper.genetrator.SsShadowsockMapper;
import com.yue.myspp.dao.mapper.genetrator.SysUserMapper;
import com.yue.myspp.entity.BlogContent;
import com.yue.myspp.entity.SsShadowsock;
import com.yue.myspp.entity.SsShadowsockExample;
import com.yue.myspp.entity.SysUser;
import com.yue.myspp.entity.SysUserExample;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class ShadowsockService {

    @Autowired
    SsShadowsockMapper ssShadowsockMapper;
    @Autowired
    UserService userService;

    public R findAll(){
        List<SsShadowsock> ssShadowsocks = ssShadowsockMapper.selectByExample(null);
        PageUtil<SsShadowsock> pageUtil = new PageUtil<>();
        pageUtil.setList(ssShadowsocks);
        return R.OK(pageUtil);
    }
    public R findOne(Long id){
        return R.OK(ssShadowsockMapper.selectByPrimaryKey(id));
    }
    public R deleteOne(Long id){
        ssShadowsockMapper.deleteByPrimaryKey(id);
        updateShadow();
        return R.OK();
    }
    public SsShadowsock findByWeId(String weId){
        SysUser sysUser = userService.findSysUserByWeId(weId);
        if(sysUser==null){
            return null;
        }
        Long ssid = sysUser.getSsId();
        if(ssid ==null){
            return null;
        }
        SsShadowsock ssShadowsock = ssShadowsockMapper.selectByPrimaryKey(ssid);
        return ssShadowsock;
    }
    public R addOrUpdateShadowsock(SsShadowsock ssShadowsock,Long uid){
        if(ssShadowsock.getId() == null){
            ssShadowsock.setSsIp("202.182.116.51");
            ssShadowsock.setStatus(1);
            ssShadowsock.setGmtCreate(new Date());
            ssShadowsock.setGmtModified(new Date());
        }
        if(StringUtils.isEmpty(ssShadowsock.getMethod())){
            ssShadowsock.setMethod("aes-256-cfb");
        }
        if(StringUtils.isEmpty(ssShadowsock.getPassword())){
            ssShadowsock.setPassword("12345678a");
        }
        if(ssShadowsock.getSsPort() == null){
            ssShadowsock.setSsPort(8386L);
        }
        SsShadowsockExample ssShadowsockExample = new SsShadowsockExample();
        ssShadowsockExample.createCriteria().andSsPortEqualTo(ssShadowsock.getSsPort());
        List<SsShadowsock> ssShadowsocks = ssShadowsockMapper.selectByExample(ssShadowsockExample);
        if(CollectionUtils.isEmpty(ssShadowsocks)){
            ssShadowsockMapper.insert(ssShadowsock);
        }else{
            ssShadowsock.setId(ssShadowsocks.get(0).getId());
            ssShadowsockMapper.updateByPrimaryKeySelective(ssShadowsock);

        }
        if(uid != null){
            SysUser sysUser = userService.findSysUserById(uid);
            if(sysUser!=null){
                sysUser.setSsId(ssShadowsock.getId());
                userService.saveOrUpdateSysUser(sysUser);
            }
        }

        ssShadowsock.getId();
        updateShadow();
        return R.OK();
    }

    public String updateShadow(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("server","0.0.0.0");
        //jsonObject.put("server_ipv6","[::]");
        jsonObject.put("local_address","127.0.0.1");
        jsonObject.put("local_port",1080);
        jsonObject.put("timeout",120);
        jsonObject.put("method","aes-256-cfb");
        jsonObject.put("protocol","origin");
        jsonObject.put("protocol_param","");
        jsonObject.put("obfs","plain");
        jsonObject.put("obfs_param","");
        jsonObject.put("redirect","");
        jsonObject.put("dns_ipv6",false);
        jsonObject.put("fast_open",false);
        jsonObject.put("workers",1);
        List<SsShadowsock> list = ssShadowsockMapper.selectByExample(null);
        JSONObject json = new JSONObject();
        for (SsShadowsock ssShadow : list){
            json.put(""+ssShadow.getSsPort(),ssShadow.getPassword());
        }
        jsonObject.put("port_password",json);
        CreateJSONFileUtil.createJsonFile(jsonObject.toJSONString(),"/etc/shadowsocks.json");
        //writeNIO(jsonObject.toJSONString());
        String msg = ShellUtil.executeLinuxCmd("/etc/init.d/shadowsocks restart");
        System.out.println(msg);
        return msg;
    }


}
