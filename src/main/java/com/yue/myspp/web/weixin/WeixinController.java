package com.yue.myspp.web.weixin;

import com.yue.myspp.pojo.weixin.MsgTypeEnum;
import com.yue.myspp.pojo.weixin.WeixinBackPojo;
import com.yue.myspp.pojo.weixin.WeixinRequestPojo;
import com.yue.myspp.service.WeixinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
public class WeixinController {

    @Autowired
    WeixinService weixinService;
    @RequestMapping
    public WeixinBackPojo weixin( @RequestBody(required=false) WeixinRequestPojo weixinRequestPojo,String signature,String timestamp,String nonce,String echostr){
        System.out.println("signature:"+signature);
        System.out.println("timestamp:"+timestamp);
        System.out.println("nonce:"+nonce);
        System.out.println("echostr:"+echostr);
        System.out.println("weixinBackPojo:"+weixinRequestPojo);
        return weixinService.handleRequest(weixinRequestPojo);
    }

}
