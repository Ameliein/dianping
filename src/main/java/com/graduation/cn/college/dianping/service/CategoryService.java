package com.graduation.cn.college.dianping.service;

import com.graduation.cn.college.dianping.common.BusinessException;
import com.graduation.cn.college.dianping.model.CategoryModel;

import java.util.List;

public interface CategoryService {

    CategoryModel create(CategoryModel categoryModel) throws BusinessException;
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();
}
