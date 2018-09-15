package com.vtomu.service;

import com.baomidou.mybatisplus.service.IService;
import com.vtomu.pojo.Scenic;

import java.util.List;

public interface ScenicService extends IService<Scenic> {

    List<Scenic> listSeletAllScenic();
}
