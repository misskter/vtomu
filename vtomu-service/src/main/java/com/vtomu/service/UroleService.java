package com.vtomu.service;

import java.util.List;

import com.vtomu.pojo.Urole;

public interface UroleService {

	List<Urole> getAll();

	Urole getUroleById(Integer Id);

}
