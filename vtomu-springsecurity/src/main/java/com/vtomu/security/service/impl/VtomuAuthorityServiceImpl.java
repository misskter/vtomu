package com.vtomu.security.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.vtomu.security.service.VtomuAuthorityService;

@Component
public class VtomuAuthorityServiceImpl implements VtomuAuthorityService {

	private AntPathMatcher antPathMatcher=new AntPathMatcher();
	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		Object principal=authentication.getPrincipal();
		boolean hasPermission=false;
		if(principal instanceof UserDetails) {
			String username=((UserDetails) principal).getUsername();
			System.out.println(username);
			
			Set<String> urls=new HashSet<String>();
			
			for (String url : urls) {
				if(antPathMatcher.match(url, request.getRequestURI())){
					hasPermission=true;
					break;
				}
			}
		}
		return hasPermission;
	}

}
