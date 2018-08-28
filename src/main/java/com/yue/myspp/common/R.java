package com.yue.myspp.common;

import com.yue.myspp.common.enums.ResultEnum;

public class R {
    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static R result(Integer code, String msg, Object data) {
        R r = new R();
        r.code=code;
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static R result(Integer code, String msg) {
        R r = new R();
        r.code=code;
        r.msg = msg;
        return r;
    }
    public static R result(ResultEnum resultEnum) {
        R r = new R();
        r.code=resultEnum.getCode();
        r.msg = resultEnum.getMsg();
        return r;
    }
    public static R result(Integer code, Object data) {
        R r = new R();
        r.code=code;
        r.data = data;
        return r;
    }

    public static R OK(){
        R r = new R();
        r.code=100;
        r.msg = "成功";
        return r;
    }
    public static R OK(Object data){
        R r = new R();
        r.code=100;
        r.msg = "成功";
        r.data = data;
        return r;
    }
    public R() {

    }


}
