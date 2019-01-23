package com.jt.springcloud.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

import feign.hystrix.FallbackFactory;
@Component
public class UserFallbackFactory implements FallbackFactory<UserService>{

	//在客户端编辑熔断的方法
	@Override
	public UserService create(Throwable cause) {
		
		return new UserService() {

			@Override
			public List<User> findAll() {
				User user = new User();
				user.setId(0);
				user.setName("后台服务器异常1");
				user.setAge(0);
				user.setSex("");
				List<User> userList = new ArrayList<User>();
				userList.add(user);
				return userList; 
			}

			@Override
			public String saveUser(User user) {
				// TODO Auto-generated method stub
				return "服务降级，熔断"+user.getName();
			}
			
		};
	}

}
