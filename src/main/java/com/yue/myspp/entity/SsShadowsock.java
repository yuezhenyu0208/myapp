package com.yue.myspp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;

public class SsShadowsock implements Serializable {
    private Long id;

    @JsonProperty("title")
    private Long ssPort;

    private String ssIp;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer status;

    private String method;

    private String password;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSsPort() {
        return ssPort;
    }

    public void setSsPort(Long ssPort) {
        this.ssPort = ssPort;
    }

    public String getSsIp() {
        return ssIp;
    }

    public void setSsIp(String ssIp) {
        this.ssIp = ssIp == null ? null : ssIp.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}