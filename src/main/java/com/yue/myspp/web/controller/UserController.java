package com.yue.myspp.web.controller;

import com.yue.myspp.common.R;
import com.yue.myspp.entity.SysUser;
import com.yue.myspp.service.UserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public R login(String username,String password,HttpServletRequest request,HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        //password = MD5Util.encrypt(username, password);
        //UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //user.setPwd(MD5Util.md5(user.getPwd()));
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Cookie cookie = new Cookie("5ddddd2tt",username);
            response.addCookie(cookie);
            return R.result(100,"成功");

        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return R.result(101, "密码错误");
        } catch (LockedAccountException e) {
            return R.result(102, "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return R.result(103, " 账号或密码不正确");
        } catch (Exception e) {
            e.printStackTrace();
            return R.result(500,"失败");
        }

    }
    @RequestMapping("/logout")
    public R logout(){
        SecurityUtils.getSubject().logout();
        return R.OK();
    }
    @PostMapping("/regist")
    public R regist(String username,String password){
        return userService.regist(username,password);
    }
    @GetMapping("/personal")
    public R personal(){
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();
        return R.OK(sysUser);
    }
}
