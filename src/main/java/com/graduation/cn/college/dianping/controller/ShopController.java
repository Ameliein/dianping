package com.graduation.cn.college.dianping.controller;

import com.graduation.cn.college.dianping.common.BusinessException;
import com.graduation.cn.college.dianping.common.CommonRes;
import com.graduation.cn.college.dianping.common.EmBusinessError;
import com.graduation.cn.college.dianping.model.CategoryModel;
import com.graduation.cn.college.dianping.model.ShopModel;
import com.graduation.cn.college.dianping.service.CategoryService;
import com.graduation.cn.college.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private CategoryService categoryService;

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

    @RequestMapping("/search")
    @ResponseBody
    public CommonRes recommend(@RequestParam(name = "longitude")BigDecimal longitude,
                               @RequestParam(name = "latitude")BigDecimal latitude,
                               @RequestParam(name = "keyword")String keyword,
                               @RequestParam(name = "orderby",required = false)Integer orderby,
                               @RequestParam(name = "categoryId",required = false)Integer categoryId,
                               @RequestParam(name = "tags",required = false)String tags) throws BusinessException {
        if (StringUtils.isEmpty(keyword) || latitude == null || longitude == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        List<ShopModel> shopModelList = shopService.search(longitude,latitude,keyword,orderby,categoryId,tags);
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        List<Map<String, Integer>> tagsAggregation = shopService.searchGroupByTags(keyword,categoryId,tags);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("shop",shopModelList);
        resMap.put("category",categoryModelList);
        resMap.put("tags",tagsAggregation);
        return CommonRes.create(resMap);
    }

}
