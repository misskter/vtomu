package com.vtomu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vtomu.dao.UroleDao;
import com.vtomu.dao.UserDao;
import com.vtomu.pojo.User;
import com.vtomu.service.UserService;
import com.vtomu.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService{


	@Autowired
	private UroleDao uroleDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User getUserNiceNameByUserId(int userId) {
		return baseMapper.getSelectArticleOwnerByUserId(userId);
	}



	public User getCurrentUser() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String username=(String)authentication.getPrincipal();
		User user=baseMapper.selectUserByUserName(username);
		return user;
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return baseMapper.selectUserByUserName(username);
	}




	@Override
	public void registerByForm(User user) {
		// TODO Auto-generated method stub
		AssertUtil.isNotBlank(user.getUsername());
		AssertUtil.isNotBlank(user.getPassword());
		AssertUtil.isNotBlank(user.getNickname());
		User other=baseMapper.selectUserByUserName(user.getUsername());
		if(other!=null) {
			return;
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		baseMapper.inserUserByForm(user);
	}

	@Override
	public void registerByEmail(User user) {
		// TODO Auto-generated method stub
		AssertUtil.checkEmail(user.getEmail());
		AssertUtil.isNotBlank(user.getChannel());
		AssertUtil.isNotBlank(user.getPassword());
		//如果是邮箱注册的话需要把邮箱注册为用户名
		user.setUsername(user.getEmail());
		user.setCreateTime(Calendar.getInstance().getTime());
		baseMapper.inserUserByForm(user);
	}

	@Override
	public void registerByMobile(User user) {
		// TODO Auto-generated method stub
		AssertUtil.isNotBlank(user.getPhone());
		//如果是手机注册的话需要把手机号注册为用户名
		user.setUsername(user.getPhone());
		user.setCreateTime(Calendar.getInstance().getTime());
		baseMapper.inserUserByForm(user);
	}

	@Override
	public void updatePassword(String password) {
		// TODO Auto-generated method stub
		
	}
	


	
	
	
}
