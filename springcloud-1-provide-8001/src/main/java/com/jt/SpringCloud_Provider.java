package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@MapperScan("com.jt.springcloud.mapper")
@EnableEurekaClient
public class SpringCloud_Provider {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloud_Provider.class, args);
	}
}
