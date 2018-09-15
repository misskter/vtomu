package com.vtomu.controller.user;

import com.vtomu.controller.base.BaseController;
import com.vtomu.pojo.Article;
import com.vtomu.pojo.User;
import com.vtomu.service.ArticleService;
import com.vtomu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;

	@GetMapping("/userDetails")
	public User userDetails() {
		return userService.getCurrentUser();
	}
	
	
	@GetMapping("/footPoint")
	public Object footPoint() {
		
		return null;
	}
 	@GetMapping("/photoAlbum")
 	public Object photoAlbum() {
 		
 		return null;
 	}

	@GetMapping("/articles")
	public List<Article> articles(){
		
		User user=userService.getCurrentUser();
		/*articleService.s*/
		return null;
	}

	/**
	 * 查看关注我的人 
	 * @return
	 */
	@GetMapping("/attention")
	public Object attention() {
		
		return null; 
	}
	
	
}
