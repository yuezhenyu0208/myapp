package com.yue.myspp.service;

import com.yue.myspp.common.MD5Util;
import com.yue.myspp.entity.SsShadowsock;
import com.yue.myspp.entity.SysUser;
import com.yue.myspp.pojo.weixin.EventEnum;
import com.yue.myspp.pojo.weixin.MsgTypeEnum;
import com.yue.myspp.pojo.weixin.WeixinBackPojo;
import com.yue.myspp.pojo.weixin.WeixinRequestPojo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeixinService {
    public static final String DEFAULT_PASSWORD = "123456";
    @Autowired
    UserService userService;

    private SysUser generatorUserByWeId(String weid){
        SysUser sysUser = new SysUser();
        Date date = new Date();
        sysUser = new SysUser();
        sysUser.setUsername(date.getTime()+"");
        sysUser.setPassword(MD5Util.encrypt(date.getTime()+"",DEFAULT_PASSWORD));
        sysUser.setWeId(weid);
        sysUser.setGmtCreate(date);
        sysUser.setGmtModified(date);
        sysUser.setStatus(new Byte("1"));
        userService.saveOrUpdateSysUser(sysUser);
        return sysUser;
    }
    @Autowired
    ShadowsockService shadowsockService;
    public WeixinBackPojo handleRequest(WeixinRequestPojo weixinRequestPojo){

        WeixinBackPojo weixinBackPojo = null;
        if(weixinRequestPojo==null){
            weixinBackPojo =  new WeixinBackPojo();
            weixinBackPojo.setContent("sdsd");
            return weixinBackPojo;
        }else{
            weixinBackPojo = new WeixinBackPojo(weixinRequestPojo);
        }
        String weid = weixinRequestPojo.getFromUserName();
        weixinBackPojo.setMsgType(MsgTypeEnum.text.getMsgType());
        String notice = "欢迎关注微信公众号：请回复数字进行操作\n"
            + "1：查询shadowsock帐号\n"
            + "2：查询网址\n"
            + "3：查询网站帐号\n"
            + "4：查询剩余帐号使用期限\n"
            + "5：查询个人id\n"
            + "6：获取帐号及充值\n"
            + "注意个人id在充值时需要提供，请务必注意，不要搞错了！\n"
            + "本服务仅面向海外华人用户，中华人民共和国境内居民禁止使用，"
            + "使用本服务请务必遵守中华人民共和国法律法规，具体使用者的一切言行，"
            + "用途和由此造成的后果，由使用者自行负责！！！";
        if(MsgTypeEnum.event.getMsgType().equals(weixinRequestPojo.getMsgType())){
            if(EventEnum.subscribe.getEvent().equals(weixinRequestPojo.getEvent())){
                //新用户订阅
                weixinBackPojo.setContent(notice);
                SysUser sysUser = userService.findSysUserByWeId(weid);
                if(sysUser ==null){
                    generatorUserByWeId(weid);
                }
            }else if(EventEnum.unsubscribe.equals(weixinRequestPojo.getEvent())){
                //取消订阅
            }
        }else if(MsgTypeEnum.text.getMsgType().equals(weixinRequestPojo.getMsgType())){
            if("1".equals(weixinRequestPojo.getContent())){
                SsShadowsock ssShadowsock = shadowsockService.findByWeId(weid);
                if(ssShadowsock==null){
                    weixinBackPojo.setContent("对不起，您暂未购买帐号。");
                }else{
                    weixinBackPojo.setContent("IP："+ssShadowsock.getSsIp()+"\n"
                        + "端口号："+ssShadowsock.getSsPort()+"\n"
                        + "密码："+ssShadowsock.getPassword()+"\n"
                        + "加密方式："+ssShadowsock.getMethod());
                }
            }else if("2".equals(weixinRequestPojo.getContent())){
                weixinBackPojo.setContent("复制这个网址 http://202.182.116.51 在浏览器打开");
            }else if("3".equals(weixinRequestPojo.getContent())){
                SysUser sysUser = userService.findSysUserByWeId(weid);
                weixinBackPojo.setContent("帐号为："+sysUser.getUsername()+"\n"
                    + "初始密码为：123456");
            }else if("4".equals(weixinRequestPojo.getContent())){
                SysUser sysUser = userService.findSysUserByWeId(weid);
                if(sysUser==null){
                    weixinBackPojo.setContent("对不起，您暂未购买帐号。");
                }else{
                    if(sysUser.getEndTime()!=null){

                        weixinBackPojo.setContent("帐号使用截至日期为："+sysUser.getEndTime());
                    }else{
                        weixinBackPojo.setContent("帐号使用截至日期为：永久");

                    }
                }
            }else if("5".equals(weixinRequestPojo.getContent())){
                SysUser sysUser = userService.findSysUserByWeId(weixinRequestPojo.getFromUserName());
                if(sysUser!=null){
                    weixinBackPojo.setContent(sysUser.getId()+"");
                }else{
                    sysUser = generatorUserByWeId(weid);
                    weixinBackPojo.setContent(sysUser.getId()+"");

                }
            }else if("6".equals(weixinRequestPojo.getContent())){
                weixinBackPojo.setContent("续费充值请添加微信号 yue10278");
            }else{
                weixinBackPojo.setContent(notice);
            }
        }
        return weixinBackPojo;
    }
}
