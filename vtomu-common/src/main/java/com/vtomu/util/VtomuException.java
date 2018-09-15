package com.vtomu.util;


public class VtomuException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VtomuException() {};
	
	public VtomuException(Throwable throwable) {
		super(throwable);
	}
	
	public VtomuException(String code) {
	    super(PropertiesUtil.getValue(code));
	}
	
	public VtomuException(String message, Throwable cause) {
	    super(message, cause);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public String getMsg() {
		return PropertiesUtil.getValue(code);
	}*/
	  /*  String msg = "";
	    if(this.errorCode == null) {
	        msg = this.getMessage();
	        return msg;
	    } else {
	        try {
	            //这里只要知道可以通过错误码获得相关错误信息
	            msg = I18nUtils.getMessage(this.errorCode, this.getMsgArgs());
	        } catch (Exception var3) {
	            msg = MessageFormat.format("错误代码: {0}, 错误参数: {1}, 国际化消息读取失败!", new Object[]{Integer.valueOf(this.errorCode.getCode()), StringUtils.join(this.getMsgArgs(), "|")});
	        }

	        return msg;
	    }
	}*/

}
