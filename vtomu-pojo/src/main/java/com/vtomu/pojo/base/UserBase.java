package com.vtomu.pojo.base;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.vtomu.pojo.Article;
import com.vtomu.pojo.Urole;


/**
 * 
 * @author imeto
 *
 */

public class UserBase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nickname;
	private String username;
	private String password;
	private String headPortrait;
	//盐值，登录验证
	private String salt;
	private String signature;
	private Integer version;
	private String address;
	private String email;
	private Date birthday;
	private String phone;
	private Integer sex;
	private Integer uroleId;
	

	private Date createTime;
	private Date updateTime;
	


	//表明注册是哪个平台
	private String channel;
	
	
	
	private Urole urole;
	
	private List<Article> articles=new ArrayList<Article>();
	
	public Date getCreateTime() {
		return createTime;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public void setCreateTime(Date createTime) {
		
		this.createTime = createTime;
	}
	public Integer getUroleId() {
		return uroleId;
	}
	public void setUroleId(Integer uroleId) {
		this.uroleId = uroleId;
	}

	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Urole getUrole() {
		return urole;
	}

	public void setUrole(Urole urole) {
		this.urole = urole;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	
	

	
	
	
	
}
