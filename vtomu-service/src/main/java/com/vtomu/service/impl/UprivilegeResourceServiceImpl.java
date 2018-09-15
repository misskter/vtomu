package com.vtomu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtomu.dao.UprivilegeResourceDao;
import com.vtomu.pojo.UprivilegeResource;
import com.vtomu.service.UprivilegeResourceService;

@Service
public class UprivilegeResourceServiceImpl implements UprivilegeResourceService{
	
	@Autowired
	private UprivilegeResourceDao  uprivilegeResourceDao;
	
	
	
	public List<UprivilegeResource> findResourceByUroleId(Integer uroleId) {
		return uprivilegeResourceDao.selectResourceByUroleId(uroleId);
	}

}
