package com.vtomu.security.authorize.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.vtomu.constant.SecurityConstants;
import com.vtomu.security.authorize.AuthorizeConfigProvider;

@Component
public class VtomuAuthorizeConfigProviderImpl implements AuthorizeConfigProvider{

	
	private static String [] permits=null;
	static {
		Class<?> clazz=SecurityConstants.class;
		Field [] fields=clazz.getFields();
		permits=new String[fields.length];
		for (int i=0;i<fields.length;i++) {
			if(Modifier.isStatic(fields[i].getModifiers())) {
				try {
					permits[i]=(String)fields[i].get(clazz);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void config(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		// TODO Auto-generated method stub
		authorizeRequests.antMatchers(permits).permitAll();
	}



}
