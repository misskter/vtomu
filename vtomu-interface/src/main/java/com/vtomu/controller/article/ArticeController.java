package com.vtomu.controller.article;

import com.baomidou.mybatisplus.plugins.Page;
import com.vtomu.constant.PaginationConstant;
import com.vtomu.controller.base.BaseController;
import com.vtomu.pojo.Article;
import com.vtomu.service.ArticleService;
import com.vtomu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticeController extends BaseController{
	@Autowired
	private ArticleService articleService;

	@Autowired
	private CommentService commentService;

/*	@GetMapping(value="/articleList/{page}")
	public List<Article> articleList(@PathVariable("page") Integer page){*/
	@GetMapping(value="/articleList/{current}")
	public Page<Article> articleList(@PathVariable("current") Integer current){
		Page<Article> page = new Page<Article>(current,PaginationConstant.DEFAULT_SIZE);
		return articleService.findArticleListBypage(page);
	}
	
	@GetMapping("/articleDetails/{articleId}")
	public Article articleDetails(@PathVariable("articleId") int articleId) {
		 Article article=articleService.findOneArticle(articleId);
		 return article;
	}
	@PostMapping(value="/addition")
	public boolean addition(@RequestBody Article article){
		/*Article article=null;*/
		articleService.addArticle(article);
/*		for (MultipartFile multipartFile : file) {
			System.out.println(multipartFile.getName());
		}*/
		return true;
	}
	
	@PostMapping(value="/praise/{articleId}")
	public Boolean praise(@PathVariable("articleId") int articleId){
		boolean flag=articleService.praiseArticle(articleId);
		return flag;
	}
	
	
	@PostMapping(value="/comment/{articleId}")
	public Boolean comment(Integer articleId){


		return true;
	}

	/**
	 * 转发
	 * @param articleId
	 * @return
	 */
	@PostMapping(value="/transmit/{articleId}")
	public Boolean transmit(int articleId){

		return true;
	}
	
	
	
	
	
}
