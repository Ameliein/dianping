//package com.graduation.cn.college.dianping.recommend;
//
//import com.graduation.cn.college.dianping.dal.RecommendDOMapper;
//import com.graduation.cn.college.dianping.model.RecommendDO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class RecommendService implements Serializable {
//    @Autowired
//    private RecommendDOMapper recommendModelMapper;
//
//    //召回数据,根据userid召回shopidlist
//    public List<Integer> recall(Integer userId){
//        RecommendDO recommendModel = recommendModelMapper.selectByPrimaryKey(userId);
//        if (recommendModel == null){
//            recommendModel = recommendModelMapper.selectByPrimaryKey(99999);
//        }
//        String[] shopIdArr = recommendModel.getRecommend().split(",");
//        List<Integer> shopIdList = new ArrayList<>();
//        for (int i=0;i < shopIdArr.length;i++){
//            shopIdList.add(Integer.valueOf(shopIdArr[i]));
//        }
//        return shopIdList;
//    }
//}
