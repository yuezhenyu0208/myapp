package com.yue.myspp.web.controller;

import com.yue.myspp.common.R;
import com.yue.myspp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping()
    public R blog(){
        return blogService.getAllContent();
    }
    @GetMapping("/{cid}")
    public R blog(@PathVariable("cid") Long cid){
        return blogService.getDetail(cid);

    }
}
