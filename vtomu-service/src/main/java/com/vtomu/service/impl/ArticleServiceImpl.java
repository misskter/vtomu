package com.vtomu.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vtomu.annotation.RedisCache;
import com.vtomu.dao.ArticleDao;
import com.vtomu.dao.PhotoDao;
import com.vtomu.pojo.*;
import com.vtomu.service.ArticleService;
import com.vtomu.service.PraiseService;
import com.vtomu.service.ScenicService;
import com.vtomu.service.UserService;
import com.vtomu.util.VtomuException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;


/**
 * @author imeto
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {


    @Autowired
    private PhotoDao photoDao;
    @Autowired
    private PraiseService praiseService;
    @Autowired
    private UserService userService;

    @Override
    @RedisCache(name = "listAllArticle", params = "page", expiresTime = 1000L)
    public Page<Article> findArticleListBypage(Page<Article> page) {
        // TODO Auto-generated method stub
        List<Article> articles = baseMapper.listArticleListByPage(page);
        for (Article article : articles) {
            List<Photo> photos = photoDao.listPhotoByArticleId(article.getId());
            article.setPhotos(photos);
            User user = userService.getUserNiceNameByUserId(article.getUserId());
            article.setUser(user);
        }
        page.setRecords(articles);
        return page;
    }


    @Override
    public void addArticle(Article article) {
        User user = userService.getCurrentUser();
        if(StringUtils.isNotBlank(article.getContent())) {
        	article.setCreateTime(Calendar.getInstance().getTime());
        	article.setUser(user);
            baseMapper.saveArticle(article);
        }
    }


    @Override
    public Article findOneArticle(int articleId) throws VtomuException {
        // TODO Auto-generated method stub
        Article article = baseMapper.getSelectOne(articleId);
        List<Photo> photos = photoDao.listPhotoByArticleId(article.getId());
        article.setPhotos(photos);
        List<Praise> praises = praiseService.listSelectPraiseByArticleId(articleId);
        for (Praise praise : praises) {
            praise.setUser(userService.getUserNiceNameByUserId(praise.getPraiseUserId()));
        }
        article.setPraises(praises);
        User user = userService.getUserNiceNameByUserId(article.getUserId());
        article.setUser(user);
        return article;
    }


    @Override
    public boolean praiseArticle(Integer articleId) {
        boolean flag = true;
        User user = userService.getCurrentUser();
        Praise praise = new Praise(user.getId(), articleId);
        int count = praiseService.countSelectPraiseByArticleIdAndUserId(praise);
        if (count > 0) {
            return flag = false;
        }
        praiseService.insertPraise(praise);
        return flag;
    }

}
