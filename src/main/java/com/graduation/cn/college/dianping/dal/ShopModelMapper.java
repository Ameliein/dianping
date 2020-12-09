package com.graduation.cn.college.dianping.dal;

import com.graduation.cn.college.dianping.model.ShopModel;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

    List<ShopModel> recommend(@Param("longitude")BigDecimal longitude, @Param("latitude")BigDecimal latitude);
    List<ShopModel> search(@Param("longitude")BigDecimal longitude,
                           @Param("latitude")BigDecimal latitude,
                           @Param("keyword")String keyword,
                           @Param("orderby")Integer orderby,
                           @Param("categoryId")Integer categoryId,
                           @Param("tags")String tags);

    List<Map<String, Integer>> searchGroupByTags(@Param("keyword")String keyword, @Param("categoryId")Integer categoryId, @Param("tags")String tags);
}