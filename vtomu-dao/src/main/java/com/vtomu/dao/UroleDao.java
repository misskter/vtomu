package com.vtomu.dao;

import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.Urole;

import java.util.List;

public interface UroleDao extends BaseDao<Urole>{

	List<Urole> listSelectAll();

	Urole getSelectOneById(Integer Id);
}
