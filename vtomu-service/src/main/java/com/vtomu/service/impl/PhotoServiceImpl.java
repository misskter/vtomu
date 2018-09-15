package com.vtomu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vtomu.dao.PhotoDao;
import com.vtomu.pojo.Photo;
import com.vtomu.service.PhotoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoDao,Photo> implements PhotoService {
    @Override
    public List<Photo> listPhotoByArticleId(Integer articleId) {

        return baseMapper.listPhotoByArticleId(articleId);
    }
}
