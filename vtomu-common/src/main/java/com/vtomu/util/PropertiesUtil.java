package com.vtomu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final  class PropertiesUtil {

	private PropertiesUtil() {}
	/**
	 * config.properties
	 */
	public final static Map<String, String> messageMap = new ConcurrentHashMap<String, String>();
	
	public final static Map<String, String> errorMap = new ConcurrentHashMap<String, String>();
	
	private final static String DEFAULT_MESSAGE_PREFIX="M_";
	
	private final static String DEFAULT_ERROR_PREFIX="E_";
	
	
	private static final String DEFAULT_MESSAGE_PROPERTIES="message.properties";
	
	private static final String DEFAULT_ERROR_PROPERTIES="error.properties";
	static {
		Properties p = null;
		try {
			InputStream in = null;
			// 实例化configMap
			p = new Properties();
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream(
					DEFAULT_MESSAGE_PROPERTIES);
			p.load(in);
			Set<Object> keys = p.keySet();
			String temp = null;
			for (Object key : keys) {
				temp = key.toString();
				messageMap.put(temp, p.getProperty(temp));
			}
			in.close();
			p = new Properties();
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream(
					DEFAULT_ERROR_PROPERTIES);
			p.load(in);
			Set<Object> errorKeys = p.keySet();
			String error = null;
			for (Object key : errorKeys) {
				error = key.toString();
				errorMap.put(error, p.getProperty(error));
			}
			in.close();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		
		if(isError(key)) {
			return messageMap.get(key);
		}else {
			return errorMap.get(key);
		}
	}
	public static boolean isError(String key) {
		String prefix=key.substring(0, 2);
		if(prefix.equals(DEFAULT_MESSAGE_PREFIX)) {
			return true;
		}else if(prefix.equals(DEFAULT_ERROR_PREFIX)){
			return false;
		}
		return false;
	}
	
	
	
}
