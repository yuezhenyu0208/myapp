package com.yue.myspp.web.controller;


import com.yue.myspp.common.R;
import com.yue.myspp.entity.SsShadowsock;
import com.yue.myspp.service.ShadowsockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shadowsock")
public class ShadowsockController {

    @Autowired
    ShadowsockService shadowsockService;

    @PostMapping
    public R Shadowsock(SsShadowsock ssShadowsock){
        return shadowsockService.addOrUpdateShadowsock(ssShadowsock);
    }
    @GetMapping
    public R insertShadowsock(){
        return shadowsockService.findAll();
    }
    @GetMapping("/{id}")
    public R insertShadowsock(@PathVariable("id") Long id){
        return shadowsockService.findOne(id);
    }
}
