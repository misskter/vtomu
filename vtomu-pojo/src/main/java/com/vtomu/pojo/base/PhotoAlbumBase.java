package com.vtomu.pojo.base;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vtomu.pojo.Article;
import com.vtomu.pojo.Photo;
import com.vtomu.pojo.User;


public class PhotoAlbumBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	//相册名称
	private String name;
	//相册描述
	private String describe;
	//相册封面
	private String cover;
	//类型0：
	private Integer albumType;
	private User user;
	//创建日期
	private Date createTime;
	private List<Photo> photos;
	public Long getId() {
		return id;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Integer getAlbumType() {
		return albumType;
	}
	public void setAlbumType(Integer albumType) {
		this.albumType = albumType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	

}
