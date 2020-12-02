package com.graduation.cn.college.dianping.service.impl;

import com.graduation.cn.college.dianping.common.AdminPermission;
import com.graduation.cn.college.dianping.dal.SellerModelMapper;
import com.graduation.cn.college.dianping.model.SellerModel;
import com.graduation.cn.college.dianping.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerModelMapper sellerModelMapper;

    @Override
    public SellerModel create(SellerModel sellerModel) {
        return null;
    }

    @Override
    public SellerModel get(Integer id) {
        return null;
    }

    @Override
    public List<SellerModel> selectAll() {
        return sellerModelMapper.selectAll();
    }

    @Override
    public SellerModel changeStatus(Integer id, Integer disabledFlag) {
        return null;
    }
}
