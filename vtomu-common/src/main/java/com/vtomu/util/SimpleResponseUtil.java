package com.vtomu.util;
public class SimpleResponseUtil {
	
	public SimpleResponseUtil(Object message){
		this.message = message;
	}
	
	private Object message;

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}
	
}