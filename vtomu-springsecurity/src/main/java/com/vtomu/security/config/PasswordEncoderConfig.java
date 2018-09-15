package com.vtomu.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vtomu.security.properties.SecurityProperties;


/**
 * PasswordEncoderConfig
 * 
 * @author vladimir.stankovic
 *
 *         Dec 27, 2016
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class PasswordEncoderConfig {
	@Bean
	protected BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
