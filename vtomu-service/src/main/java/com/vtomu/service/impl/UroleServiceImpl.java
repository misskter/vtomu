package com.vtomu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vtomu.dao.UroleDao;
import com.vtomu.pojo.Urole;
import com.vtomu.service.UroleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UroleServiceImpl extends ServiceImpl<UroleDao,Urole> implements UroleService{


	public List<Urole> getAll() {
		// TODO Auto-generated method stub
		return baseMapper.listSelectAll();
	}


	public Urole getUroleById(Integer Id) {
		// TODO Auto-generated method stub
		return baseMapper.getSelectOneById(Id);
	}

	
	
}
