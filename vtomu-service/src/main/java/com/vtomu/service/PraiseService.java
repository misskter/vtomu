package com.vtomu.service;

import com.vtomu.pojo.Praise;

import java.util.List;

public interface PraiseService {

   int  countSelectPraiseByArticleIdAndUserId(Praise praise);

   void insertPraise(Praise praise);

   List<Praise> listSelectPraiseByArticleId(int articleId);
}
