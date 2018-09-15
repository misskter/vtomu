package com.vtomu.pojo.base;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vtomu.pojo.UroleUprivilege;
import com.vtomu.pojo.User;


/**
 * 
 * @author mk
 *
 */
public class UroleBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Integer UROLE_ADMIN=1000;//admin_code
	public static final Integer UROLE_USER=200;//user_code
	public static final Integer UROLE_MEMBER=300;//member_code
	private Integer id;
	private String name;
	private Integer code;
	private String description;
	
	


	private List<UroleUprivilege> uroleUprivilege;
	public List<UroleUprivilege> getUroleUprivilege() {
		return uroleUprivilege;
	}

	public void setUroleUprivilege(List<UroleUprivilege> uroleUprivilege) {
		this.uroleUprivilege = uroleUprivilege;
	}

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



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	
}
