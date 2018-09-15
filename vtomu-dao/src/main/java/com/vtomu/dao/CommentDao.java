package com.vtomu.dao;

import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.Comment;

import java.util.List;

public interface CommentDao extends BaseDao<Comment>{

    void insertComment(Comment comment);

    List<Comment> listCommentByArticleId(int articleId);



}
