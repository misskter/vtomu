package com.vtomu.dao;

import com.vtomu.dao.base.BaseDao;
import com.vtomu.pojo.Praise;

import java.util.List;



public interface PraiseDao extends BaseDao<Praise>{

    int insertPraise(Praise praise);


    List<Praise> listSelectPraiseByArticleId(Integer articleId);
    /**
     * 查询当前用户给某个说说赞的个数
     * @return
     */
    int countSelectPraiseByArticleIdAndUserId(Praise praise);
    
}