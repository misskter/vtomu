package com.vtomu.security;


import com.vtomu.constant.SecurityConstants;
import com.vtomu.security.authentication.email.EmailCodeAuthenticationSecurityConfig;
import com.vtomu.security.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.vtomu.security.authorize.AuthorizeConfigManager;
import com.vtomu.security.handler.VtomuAuthenticationFailureHandler;
import com.vtomu.security.handler.VtomuAuthenticationSuccessHandler;
import com.vtomu.security.properties.SecurityProperties;
import com.vtomu.security.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;



@Configuration
@EnableResourceServer
public class VtomuResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	@Autowired
	private EmailCodeAuthenticationSecurityConfig emailCodeAuthenticationSecurityConfig;
	
	@Autowired
	private VtomuAuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private VtomuAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private AuthorizeConfigManager authorizeConfigManager;
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
		formLogin()
		.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
		.successHandler(authenticationSuccessHandler)
		.failureHandler(authenticationFailureHandler);
		http
		.apply(validateCodeSecurityConfig)
		.and()
		.apply(smsCodeAuthenticationSecurityConfig)
		.and()
		.apply(emailCodeAuthenticationSecurityConfig)
		.and()
		.csrf().disable();
		authorizeConfigManager.config(http.authorizeRequests());
		
	}
		

}
