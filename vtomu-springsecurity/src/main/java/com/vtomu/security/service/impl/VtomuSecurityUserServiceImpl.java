package com.vtomu.security.service.impl;

import com.vtomu.dao.UroleDao;
import com.vtomu.dao.UserDao;
import com.vtomu.pojo.Urole;
import com.vtomu.pojo.User;
import com.vtomu.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class VtomuSecurityUserServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UroleDao uroleDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AssertUtil.isNotBlank(username);
		User user = userDao.selectUserByUserName(username);
		if (user != null) {
			int uroleId=user.getUroleId();
			Urole urole=uroleDao.getSelectOneById(uroleId);
			String password = passwordEncoder.encode(user.getPassword());
			return new org.springframework.security.core.userdetails.User(username, password,
					AuthorityUtils.createAuthorityList(urole.getName()));
		} else {
			throw new UsernameNotFoundException("auth  failure");
		}
		// TODO Auto-generated method stub
	}

}
