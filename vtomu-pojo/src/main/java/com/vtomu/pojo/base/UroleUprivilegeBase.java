package com.vtomu.pojo.base;


import java.io.Serializable;

import com.vtomu.pojo.Uprivilege;
import com.vtomu.pojo.Urole;

/**
 * 角色权限父类
 * @author imeto
 *
 */

public class UroleUprivilegeBase implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private Urole urole;
	private Uprivilege uprivilege;

	public Urole getUrole() {
		return urole;
	}
	public void setUrole(Urole urole) {
		this.urole = urole;
	}
	public Uprivilege getUprivilege() {
		return uprivilege;
	}
	public void setUprivilege(Uprivilege uprivilege) {
		this.uprivilege = uprivilege;
	}
	
	
	
}
