package com.vtomu.pojo.base;


import java.io.Serializable;
import java.util.Objects;


/**
 * 
 * @author imeto
 *
 */

public class CollectBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer articleId;

	private Integer userId;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CollectBase that = (CollectBase) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(articleId, that.articleId) &&
				Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, articleId, userId);
	}

	@Override

	public String toString() {
		return "CollectBase{" +
				"id=" + id +
				", articleId=" + articleId +
				", userId=" + userId +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
