package com.yue.myspp.web.controller;

import com.yue.myspp.entity.SysUser;
import com.yue.myspp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping
    public SysUser getUser(){
        return userService.findUserByName();
    }

}
