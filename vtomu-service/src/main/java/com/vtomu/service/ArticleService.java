package com.vtomu.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.vtomu.pojo.Article;
import com.vtomu.util.VtomuException;

import java.util.List;

public interface ArticleService {

	 Page<Article> findArticleListBypage(Page<Article> page) ;
	
	 void addArticle(Article article) ;
	
	 Article findOneArticle(int articleId) throws VtomuException;
	
	 boolean praiseArticle(Integer articleId);
}
