package com.yue.myspp.pojo.weixin;

public enum MsgTypeEnum {
    text("text"),image("image"),voice("voice"),video("video"),shortvideo("shortvideo"),location("location")
    ,link("link"),event("event");
    String msgType;

    MsgTypeEnum(String msgType) {
        this.msgType = msgType;
    }
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }
}
