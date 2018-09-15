package com.vtomu.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vtomu.pojo.Scenic;

import java.util.List;

public interface ScenicDao extends BaseMapper<Scenic> {


    List<Scenic> listSelectAllScenic();


}
