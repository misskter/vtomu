package com.vtomu.controller.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtomu.controller.base.BaseController;
import com.vtomu.pojo.User;
import com.vtomu.service.UserService;

@RestController
public class LoginController extends BaseController{

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/loginCheck")
	public User login(@RequestBody User user) {
		User users=userService.getUserByUsername(user.getUsername());
		return users;
	}
	
	
	
}
