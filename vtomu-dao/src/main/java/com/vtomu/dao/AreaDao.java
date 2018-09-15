package com.vtomu.dao;

import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.Area;

import java.util.List;

public interface AreaDao extends BaseDao<Area>{


	/**
	 * 根据城市ID获取区域
	 * @param cityId
	 * @return
	 */
	List<Area> listAreaByCityId(Integer cityId);
}
