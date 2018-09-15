package com.vtomu.service;

import com.vtomu.pojo.User;

public interface UserService {
	/**
	 * 取出token认证后的用户
	 * @return
	 */
	User getCurrentUser();
	/**
	 * 根据用户名获取当前用户
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	/**
	 * 表单注册
	 * @param user
	 */
	void registerByForm(User user);
	/**
	 * 邮箱注册
	 */
	void registerByEmail(User user);
	/**
	 * 手机号注册
	 * @param mobile
	 */
	void registerByMobile(User user);
	/**
	 * 使用手机或者邮箱注册的用户没有密码，所以需要修改
	 * @param password
	 */
	void updatePassword(String password);

	User getUserNiceNameByUserId(int userId);

}
