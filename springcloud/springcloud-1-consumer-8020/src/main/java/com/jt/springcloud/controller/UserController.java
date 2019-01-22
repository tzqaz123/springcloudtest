package com.jt.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

@RestController
public class UserController {
	
	//private static final String provider_url = "http://localhost:8000";
	/*
	 * private static final String provider_url = "http://PROVIDER-USER";
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * @SuppressWarnings("unchecked") //压制警告
	 * 
	 * @RequestMapping("/findAll") public List<User> findAll(){
	 * 
	 * return restTemplate.getForObject(provider_url+"/findAll", List.class); }
	 * //实现用户信息新增
	 * 
	 * @RequestMapping("/saveUser/{name}/{age}/{sex}") public String saveUser(User
	 * user) { return restTemplate.postForObject(provider_url+"/saveUser", user,
	 * String.class); }
	 */
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll") 
	public List<User> findAll(){
		return userService.findAll();
	}
	
	 @RequestMapping("/saveUser/{name}/{age}/{sex}")
	 public String saveUser(User user) {
		 return userService.saveUser(user);
	 }
}
