package com.vtomu.service;

import java.util.List;

import com.vtomu.pojo.UprivilegeResource;

public interface UprivilegeResourceService {

	List<UprivilegeResource> findResourceByUroleId(Integer uroleId);
	
}
