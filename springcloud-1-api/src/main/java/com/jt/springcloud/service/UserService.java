package com.jt.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.springcloud.pojo.User;
@FeignClient(value="provider-user",fallbackFactory=com.jt.springcloud.factory.UserFallbackFactory.class)
public interface UserService {
	@RequestMapping("/findAll")
	public List<User> findAll();
	
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user);
	
}
