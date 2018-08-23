package com.yue.myspp.web.weixin;

import com.yue.myspp.pojo.weixin.WeixinBackPojo;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
public class WeixinController {

    @RequestMapping
    public String weixin(@RequestBody WeixinBackPojo weixinBackPojo,String signature,String timestamp,String nonce,String echostr){
        System.out.println("signature:"+signature);
        System.out.println("timestamp:"+timestamp);
        System.out.println("nonce:"+nonce);
        System.out.println("echostr:"+echostr);
        System.out.println("weixinBackPojo:"+weixinBackPojo);
        return echostr;
    }
}
