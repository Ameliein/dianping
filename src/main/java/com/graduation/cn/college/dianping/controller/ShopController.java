package com.graduation.cn.college.dianping.controller;

import com.graduation.cn.college.dianping.common.BusinessException;
import com.graduation.cn.college.dianping.common.CommonRes;
import com.graduation.cn.college.dianping.common.EmBusinessError;
import com.graduation.cn.college.dianping.model.ShopModel;
import com.graduation.cn.college.dianping.service.CategoryService;
import com.graduation.cn.college.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;
//    @Autowired
//    private CategoryService categoryService;

    @RequestMapping("/recommend")
    @ResponseBody
    public CommonRes recommend(@RequestParam(name = "longitude")BigDecimal longitude, @RequestParam(name = "latitude")BigDecimal latitude) throws BusinessException {
        if (latitude == null || longitude == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<ShopModel> shopModelList = shopService.recommend(longitude,latitude);
        return CommonRes.create(shopModelList);
    }
}
