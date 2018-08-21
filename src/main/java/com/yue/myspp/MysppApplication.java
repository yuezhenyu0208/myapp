package com.yue.myspp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MysppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysppApplication.class, args);
	}
}
