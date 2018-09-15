package com.vtomu.email.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:email.properties")
public class EmailConfig {


	 @Value("${vtomu.mail.host}")
	    private String host;

	    @Value("${vtomu.mail.port}")
	    private Integer port;

	    @Value("${vtomu.mail.username}")
	    private String username;

	    @Value("${vtomu.mail.password}")
	    private String password;

	    @Value("${vtomu.mail.default-encoding}")
	    private String defaultEncoding;

	    @Bean
	    public JavaMailSender javaMailSender() {
	        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	        javaMailSender.setHost(host);
	        javaMailSender.setPort(port);
	        javaMailSender.setUsername(username);
	        javaMailSender.setPassword(password);
	        javaMailSender.setDefaultEncoding(defaultEncoding);
	        javaMailSender.setJavaMailProperties(getMailProperties());
	        return javaMailSender;
	    }

	    private Properties getMailProperties() {
	        Properties properties = new Properties();
	        properties.setProperty("mail.transport.protocol", "smtp");
	        properties.setProperty("mail.smtp.auth", "true");
	        properties.setProperty("mail.smtp.starttls.enable", "true");
	        properties.setProperty("mail.debug", "true");
	        return properties;
	    }
	
	
	
	
	
	
	
}
