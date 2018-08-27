package com.yue.myspp.service;

import com.yue.myspp.entity.SsShadowsock;
import com.yue.myspp.entity.SysUser;
import com.yue.myspp.pojo.weixin.EventEnum;
import com.yue.myspp.pojo.weixin.MsgTypeEnum;
import com.yue.myspp.pojo.weixin.WeixinBackPojo;
import com.yue.myspp.pojo.weixin.WeixinRequestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeixinService {

    @Autowired
    UserService userService;

    @Autowired
    ShadowsockService shadowsockService;
    public WeixinBackPojo handleRequest(WeixinRequestPojo weixinRequestPojo){
        String weid = weixinRequestPojo.getFromUserName();
        WeixinBackPojo weixinBackPojo = null;
        if(weixinRequestPojo==null){
            weixinBackPojo =  new WeixinBackPojo();
            weixinBackPojo.setContent("sdsd");
            return weixinBackPojo;
        }else{
            weixinBackPojo = new WeixinBackPojo(weixinRequestPojo);
        }
        weixinBackPojo.setMsgType(MsgTypeEnum.text.getMsgType());
        String notice = "欢迎关注微信公众号：请回复数字进行操作\n"
            + "1：查询shadowsock帐号\n"
            + "2：查询网址\n"
            + "3：查询网站帐号\n"
            + "4：查询剩余帐号使用期限\n"
            + "5：查询个人id\n"
            + "6：获取帐号及充值\n"
            + "注意个人id在充值时需要提供，请务必注意，不要搞错了！";
        if(MsgTypeEnum.event.getMsgType().equals(weixinRequestPojo.getMsgType())){
            if(EventEnum.subscribe.equals(weixinRequestPojo.getEvent())){
                //新用户订阅
                weixinBackPojo.setContent(notice);
                SysUser sysUser = userService.findSysUserByWeId(weid);
                if(sysUser ==null){
                    sysUser = new SysUser();

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
                weixinBackPojo.setContent("复制这个网址 http://52tt.xyz 在浏览器打开");
            }else if("3".equals(weixinRequestPojo.getContent())){
                SysUser sysUser = userService.findSysUserByWeId(weid);
                weixinBackPojo.setContent("帐号为："+sysUser.getUsername()+"\n"
                    + "密码为：123456");
            }else if("4".equals(weixinRequestPojo.getContent())){
                SysUser sysUser = userService.findSysUserByWeId(weid);
                if(sysUser==null){
                    weixinBackPojo.setContent("对不起，您暂未购买帐号。");
                }else{
                    weixinBackPojo.setContent("帐号使用截至日期为："+sysUser.getEndTime());
                }
            }else if("5".equals(weixinRequestPojo.getContent())){
                weixinBackPojo.setContent(weixinRequestPojo.getFromUserName());
            }else if("6".equals(weixinRequestPojo.getContent())){
                weixinBackPojo.setContent("续费充值请添加微信号 yue10278");
            }else{
                weixinBackPojo.setContent(notice);
            }
        }


        return weixinBackPojo;
    }
}
