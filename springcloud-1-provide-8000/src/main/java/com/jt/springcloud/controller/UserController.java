package com.jt.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	@RequestMapping("/findAll")
	@HystrixCommand(fallbackMethod="hystrix_findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	public List<User> hystrix_findAll(){
		User user = new User();
		user.setId(0);
		user.setName("后台服务器异常");
		user.setAge(0);
		user.setSex("");
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		return userList; 
	}
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user){
		userService.saveUser(user);
		return "8000用户新增完成"+user.getName();
	}
}
