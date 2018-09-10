package com.yue.myspp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan("com.yue.myspp.dao.mapper")
public class MysppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysppApplication.class, args);
		System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","|,`");
	}
}
