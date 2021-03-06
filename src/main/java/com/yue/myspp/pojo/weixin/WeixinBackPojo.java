package com.yue.myspp.pojo.weixin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.mybatis.generator.api.dom.java.Interface;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeixinBackPojo {

    private Integer id;

    @XmlElement(name="ToUserName")
    private String toUserName;

    @XmlElement(name="FromUserName")
    private String fromUserName;

    @XmlElement(name="CreateTime")
    private Integer createTime;

    @XmlElement(name="MsgType")
    private String msgType;

    @XmlElement(name="Content")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public WeixinBackPojo(WeixinRequestPojo weixinRequestPojo){
        this.toUserName = weixinRequestPojo.getFromUserName();
        this.fromUserName = weixinRequestPojo.getToUserName();
        this.createTime = weixinRequestPojo.getCreateTime();
    }
    public WeixinBackPojo(){

    }

}
