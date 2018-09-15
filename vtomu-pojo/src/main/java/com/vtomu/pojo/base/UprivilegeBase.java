package com.vtomu.pojo.base;


import java.io.Serializable;
import java.util.List;

import com.vtomu.pojo.UprivilegeResource;
import com.vtomu.pojo.UroleUprivilege;

/**
 * 权限父类（负责组装角色和对应的资源）
 * @author mk
 *
 */
public class UprivilegeBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private List<UroleUprivilege> uroleUprivilege;
	public List<UroleUprivilege> getUroleUprivilege() {
		return uroleUprivilege;
	}
	public void setUroleUprivilege(List<UroleUprivilege> uroleUprivilege) {
		this.uroleUprivilege = uroleUprivilege;
	}
	private List<UprivilegeResource> uprivilegeResource;
	public List<UprivilegeResource> getUprivilegeResource() {
		return uprivilegeResource;
	}
	public void setUprivilegeResource(List<UprivilegeResource> uprivilegeResource) {
		this.uprivilegeResource = uprivilegeResource;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
