package com.graduation.cn.college.dianping.dal;

import com.graduation.cn.college.dianping.model.CategoryModel;

import java.util.List;

public interface CategoryModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 04 16:01:16 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 04 16:01:16 CST 2020
     */
    int insert(CategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 04 16:01:16 CST 2020
     */
    int insertSelective(CategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 04 16:01:16 CST 2020
     */
    CategoryModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 04 16:01:16 CST 2020
     */
    int updateByPrimaryKeySelective(CategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbg.generated Fri Dec 04 16:01:16 CST 2020
     */
    int updateByPrimaryKey(CategoryModel record);

    List<CategoryModel> selectAll();

    Integer countAllCategory();
}