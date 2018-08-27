package com.yue.myspp.pojo.weixin;

public enum EventEnum {
    subscribe("subscribe"),unsubscribe("unsubscribe");
    private String event;

    EventEnum(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
