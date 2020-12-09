package com.graduation.cn.college.dianping.service;

import com.graduation.cn.college.dianping.common.BusinessException;
import com.graduation.cn.college.dianping.model.ShopModel;

import java.math.BigDecimal;
import java.util.List;

public interface ShopService {

    ShopModel create(ShopModel shopModel) throws BusinessException;
    ShopModel get(Integer id);
    List<ShopModel> selectAll();

    Integer countAllShop();

    List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude);
}
