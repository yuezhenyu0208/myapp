package com.yue.myspp.common;

import java.util.List;

public class PageUtil<T> {

    Integer pageSize;
    Integer pageNum;
    Long totalCount;
    List<T> list;

    public PageUtil() {
    }

    public PageUtil(Integer pageSize, Integer pageNum, Long totalCount, List<T> list) {

        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalCount = totalCount;
        this.list = list;
    }

    public Integer getPageSize() {

        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
