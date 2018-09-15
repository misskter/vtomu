package com.vtomu.service.impl;

import com.vtomu.dao.CommentDao;
import com.vtomu.pojo.Comment;
import com.vtomu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;
    @Override
    public void insertComment(Comment comment) {

    }

    @Override
    public List<Comment> listCommontByArticleId(int articleId) {



        return null;
    }

    @Override
    public List<Comment> listHanlderTreeComment(List<Comment> comments) {



        return null;
    }
}
