package com.vtomu.service;

import com.vtomu.pojo.Photo;
import java.util.List;

public interface PhotoService {
    List<Photo> listPhotoByArticleId(Integer articleId);
}
