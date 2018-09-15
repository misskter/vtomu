package com.vtomu.dao;

import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.Photo;

import java.util.List;

public interface PhotoDao extends BaseDao<Photo>{

	List<Photo> listPhotoByArticleId(Integer articleId);
	
	
	
}
