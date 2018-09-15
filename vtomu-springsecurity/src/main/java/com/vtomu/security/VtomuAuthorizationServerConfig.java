package com.vtomu.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.vtomu.security.properties.Oauth2ClientProperties;
import com.vtomu.security.properties.SecurityProperties;



@Configuration
@EnableAuthorizationServer
public class VtomuAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired(required=false)
	private TokenEnhancer jwtTokenEnhance;

	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired(required=false)
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		InMemoryClientDetailsServiceBuilder builder=clients.inMemory();
		if(ArrayUtils.isNotEmpty(securityProperties.getOauth2().getClients())) {
			for(Oauth2ClientProperties client:securityProperties.getOauth2().getClients()) {
				builder.withClient(client.getClientId())
				.secret(client.getClientSecret())
				.accessTokenValiditySeconds(client.getAccessTokenValiditySeconds())
				.authorizedGrantTypes("refresh_token","password")
				.scopes("all","reade","write");
				
			}
			
		}
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		.tokenStore(tokenStore)
		.authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService);
		if(jwtAccessTokenConverter!=null && jwtTokenEnhance!=null) {
			TokenEnhancerChain enhancerChain=new TokenEnhancerChain();
			List<TokenEnhancer> enhancers=new ArrayList<>();
			enhancers.add(jwtTokenEnhance);
			enhancers.add(jwtAccessTokenConverter);
			enhancerChain.setTokenEnhancers(enhancers);					
			endpoints
			.tokenEnhancer(enhancerChain)
			.accessTokenConverter(jwtAccessTokenConverter);
			
		}
	}
	
	
}
