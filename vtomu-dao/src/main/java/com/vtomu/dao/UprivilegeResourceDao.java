package com.vtomu.dao;

import java.util.List;


import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.UprivilegeResource;

public interface UprivilegeResourceDao extends BaseDao<UprivilegeResource>{

	 List<UprivilegeResource> selectResourceByUroleId(Integer uroleId);
	
}
