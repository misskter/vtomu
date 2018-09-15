package com.vtomu.pojo;


import com.vtomu.pojo.base.ArticleBase;

import java.util.ArrayList;
import java.util.List;


public class Article extends ArticleBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Photo> photos = new ArrayList<Photo>();
	private User user;
	private List<Praise> praises = new ArrayList<Praise>();
	private List<Comment> comments = new ArrayList<Comment>();
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Praise> getPraises() {
		return praises;
	}

	public void setPraises(List<Praise> praises) {
		this.praises = praises;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}


}
