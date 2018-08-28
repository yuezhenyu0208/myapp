package com.yue.myspp.common.enums;

public enum ResultEnum {
    SUCCESS(100,"成功"),NOLOGIN(105,"未登录"),PASSWORD_ERROR(101, "账号或密码不正确"),DONGJIE(102, "登录失败，该用户已被冻结"),
    PASSWORD_REPEAT(103,"用户名已存在"),
    ERROR(500,"系统错误");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
