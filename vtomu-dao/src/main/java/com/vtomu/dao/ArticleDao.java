package com.vtomu.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.Article;

import java.util.List;

public interface ArticleDao extends BaseDao<Article>{

	 List<Article> listArticleListByPage(Pagination page);
	 Article getSelectOne(Integer Id);
	 void saveArticle(Article article);


	 List<Article> listAllArticle();
	
	
}
