package com.vtomu.dao;

import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.Province;

import java.util.List;

public interface ProvinceDao extends BaseDao<Province>{

	List<Province> listProvinceAll();
}
