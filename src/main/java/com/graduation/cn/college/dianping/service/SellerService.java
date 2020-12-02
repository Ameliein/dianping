package com.graduation.cn.college.dianping.service;

import com.graduation.cn.college.dianping.model.SellerModel;

import java.util.List;

public interface SellerService {
    SellerModel create(SellerModel sellerModel);
    SellerModel get(Integer id);
    List<SellerModel> selectAll();
    SellerModel changeStatus(Integer id, Integer disabledFlag);
}
