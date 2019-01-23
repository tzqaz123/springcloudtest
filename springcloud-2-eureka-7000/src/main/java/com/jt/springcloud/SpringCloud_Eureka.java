package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 1pom.xml添加jar包
 * 2编辑yml.xml文件
 * 3编辑启动项
 * @author Administrator
 *
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class SpringCloud_Eureka {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloud_Eureka.class, args);
	}
}
