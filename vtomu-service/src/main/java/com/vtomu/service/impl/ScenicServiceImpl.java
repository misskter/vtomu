package com.vtomu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vtomu.dao.ScenicDao;
import com.vtomu.pojo.Scenic;
import com.vtomu.service.ScenicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicServiceImpl extends ServiceImpl<ScenicDao,Scenic> implements ScenicService {


    @Override
    public List<Scenic> listSeletAllScenic() {


        return baseMapper.listSelectAllScenic();
    }
}
