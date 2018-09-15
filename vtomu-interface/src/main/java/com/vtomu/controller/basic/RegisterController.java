package com.vtomu.controller.basic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtomu.controller.base.BaseController;
import com.vtomu.pojo.User;
import com.vtomu.service.UserService;
import com.vtomu.util.VtomuException;

@RestController
public class RegisterController extends BaseController{

	@Autowired
	private UserService userService;

	@PostMapping("/registerCheck/form")
	public String register(@RequestBody User user) throws VtomuException {
		
		
		userService.registerByForm(user);
		return "ok";
	}
	
	@PostMapping("/registerCheck/email")
	public String registerByEmail(@RequestBody User  user) throws VtomuException {
		userService.registerByEmail(user);
		return "ok";
	}
	
	
}
