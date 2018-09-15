package com.vtomu.pojo;

import com.vtomu.pojo.base.PraiseBase;

/**
 * 点赞的表
 * @author imeto
 *
 */
public class Praise extends PraiseBase {
	public Praise() {
	}
	public Praise(Integer praiseUserId, Integer articleId) {
		super(praiseUserId, articleId);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Article article;
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
