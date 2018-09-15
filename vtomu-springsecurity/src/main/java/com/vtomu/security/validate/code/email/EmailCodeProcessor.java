package com.vtomu.security.validate.code.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.vtomu.constant.SecurityConstants;
import com.vtomu.security.validate.code.ValidateCode;
import com.vtomu.security.validate.code.impl.AbstractValidateCodeProcessor;

@Component("emailValidateCodeProcessor")
public class EmailCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode>{

	@Autowired
	private EmailCodeSender emailCodeSender;
	
	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
		// TODO Auto-generated method stub
		String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_EMAIL;
		String email = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
		emailCodeSender.send(email, validateCode.getCode());
	}

}
