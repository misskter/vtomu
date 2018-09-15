package com.vtomu.service;

import com.vtomu.pojo.Comment;
import java.util.List;

public interface CommentService {

	void insertComment(Comment comment);
	
	List<Comment> listCommontByArticleId(int articleId);

	List<Comment> listHanlderTreeComment(List<Comment> comments);

}
