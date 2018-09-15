package com.vtomu.pojo.base;


import java.io.Serializable;

import com.vtomu.pojo.Uprivilege;
import com.vtomu.pojo.Urole;

/**
 * 
 * @author imeto
 *
 */
public class UprivilegeResourceBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
	private Integer code;
	
	private String url;
	
	private Integer uroleId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUroleId() {
		return uroleId;
	}

	public void setUroleId(Integer uroleId) {
		this.uroleId = uroleId;
	}







	



	
	
}
