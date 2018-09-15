package com.vtomu.security.validate.code.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vtomu.email.provider.EmailSend;

@Component
public class EmailCodeSenderImpl implements EmailCodeSender{

	@Autowired
	private EmailSend emailSend;
	
	@Override
	public void send(String email, String code) {
		// TODO Auto-generated method stub
		System.out.println(email + "" +code);
		/*emailSend.sendSimpleMail(email, "验证码", code);*/
	}

}
