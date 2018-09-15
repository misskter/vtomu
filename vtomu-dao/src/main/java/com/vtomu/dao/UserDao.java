package com.vtomu.dao;

import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.User;

public interface UserDao extends BaseDao<User>{

	User selectUserByUserName(String username);

	void inserUserByForm(User user);

	
	
	void inserUserByUserName(User user);
	/**
	 * 根据文章ID查询用户，只返回用户的ID，昵称，还有头像地址
	 * @param userId
	 * @return
	 */
	User getSelectArticleOwnerByUserId(Integer userId);
	
	
}