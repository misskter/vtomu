package com.vtomu.security.authorize.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.vtomu.security.authorize.AuthorizeConfigManager;
import com.vtomu.security.authorize.AuthorizeConfigProvider;

@Component
public class VtomuAuthorizeConfigManagerImpl implements AuthorizeConfigManager{

	@Autowired
	private Set<AuthorizeConfigProvider> authorizeConfigProviders;
	
	
	@Override
	public void config(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		// TODO Auto-generated method stub
		for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
			authorizeConfigProvider.config(authorizeRequests);
		}
		
		authorizeRequests.anyRequest().authenticated();
	}

	
	
	
	
}
