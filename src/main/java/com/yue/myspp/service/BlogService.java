package com.yue.myspp.service;

import com.yue.myspp.common.PageUtil;
import com.yue.myspp.common.R;
import com.yue.myspp.dao.BlogContentMapper;
import com.yue.myspp.entity.BlogContent;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogContentMapper blogContentMapper;

    public R getAllContent(){
        List<BlogContent> list = this.blogContentMapper.selectByExample(null);
        PageUtil<BlogContent> pageUtil = new PageUtil<>();
        pageUtil.setList(list);
        return R.OK(pageUtil);
    }

    public R getDetail(Long cid){
        BlogContent blogContent = blogContentMapper.selectByPrimaryKey(cid);
        return R.OK(blogContent);
    }

}
