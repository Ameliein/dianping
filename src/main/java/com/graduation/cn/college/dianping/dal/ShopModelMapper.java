package com.graduation.cn.college.dianping.dal;

import com.graduation.cn.college.dianping.model.ShopModel;

import java.util.List;

public interface ShopModelMapper {

    List<ShopModel> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Fri Dec 04 17:00:30 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Fri Dec 04 17:00:30 CST 2020
     */
    int insert(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Fri Dec 04 17:00:30 CST 2020
     */
    int insertSelective(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Fri Dec 04 17:00:30 CST 2020
     */
    ShopModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Fri Dec 04 17:00:30 CST 2020
     */
    int updateByPrimaryKeySelective(ShopModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop
     *
     * @mbg.generated Fri Dec 04 17:00:30 CST 2020
     */
    int updateByPrimaryKey(ShopModel record);

    Integer countAllShop();
}