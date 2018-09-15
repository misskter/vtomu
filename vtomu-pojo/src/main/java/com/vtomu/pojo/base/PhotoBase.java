package com.vtomu.pojo.base;


import java.io.Serializable;

import com.vtomu.pojo.Article;
import com.vtomu.pojo.PhotoAlbum;

public class PhotoBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String path;

	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	
	
}
