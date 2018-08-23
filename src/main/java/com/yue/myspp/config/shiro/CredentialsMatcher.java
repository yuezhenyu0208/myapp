package com.yue.myspp.config.shiro;

import com.yue.myspp.common.MD5Util;
import java.util.Objects;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义密码比较规则
 * @author Administrator
 *
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher{



    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(utoken.getPassword());
        String username = utoken.getUsername();
        //获得数据库中的密码
        String dbPassword = (String) info.getCredentials();
        SimpleAuthenticationInfo saInfo = (SimpleAuthenticationInfo)info;
//        ByteSource salt = saInfo.getCredentialsSalt();
       /* ByteSource salt = ByteSource.Util.bytes(username);
        inPassword = new SimpleHash("sha-1", //加密方式
            inPassword,//密码原值
            salt,//盐值
            916//加密次数
        ).toString();*/
        inPassword = MD5Util.encrypt(username, inPassword);
        //进行密码的比对
        boolean flag = Objects.equals(inPassword, dbPassword);
        return flag;
    }
}