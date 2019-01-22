package com.jt.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	@RequestMapping("/findAll")
	public List<User> findAll(){
		
		return userService.findAll();
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user){
		userService.saveUser(user);
		return "8001用户新增完成"+user.getName();
	}
}
