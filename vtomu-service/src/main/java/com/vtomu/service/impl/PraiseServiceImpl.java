package com.vtomu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vtomu.dao.PraiseDao;
import com.vtomu.pojo.Praise;
import com.vtomu.service.PraiseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PraiseServiceImpl extends ServiceImpl<PraiseDao,Praise> implements PraiseService {

    @Override
    public int countSelectPraiseByArticleIdAndUserId(Praise praise) {


        return baseMapper.countSelectPraiseByArticleIdAndUserId(praise);
    }


    @Override
    public void insertPraise(Praise praise) {
        baseMapper.insert(praise);
    }

    @Override
    public List<Praise> listSelectPraiseByArticleId(int articleId) {
        return baseMapper.listSelectPraiseByArticleId(articleId);
    }
}
