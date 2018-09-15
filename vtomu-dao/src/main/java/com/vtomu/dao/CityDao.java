package com.vtomu.dao;

import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.City;

import java.util.List;

public interface CityDao extends BaseDao<City>{
	/**
	 * 根据省分ID获取城市集合
	 * @param provinceId
	 * @return
	 */
	List<City> listSelectAllCity(Integer provinceId);
	
	
}
