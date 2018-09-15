package com.vtomu.security.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;


/**
 * 判断是否有权限可以访问连接
 * @author imeto
 *
 */
public interface VtomuAuthorityService {

	/**
	 * 是否可以访问 
	 * true:可以
	 * false:403不可以访问
	 * @return
	 */
	boolean hasPermission(HttpServletRequest request,Authentication authentication);
	
	
}
