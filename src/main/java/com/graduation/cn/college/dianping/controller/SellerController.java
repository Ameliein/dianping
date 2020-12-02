package com.graduation.cn.college.dianping.controller;

import com.graduation.cn.college.dianping.common.AdminPermission;
import com.graduation.cn.college.dianping.model.SellerModel;
import com.graduation.cn.college.dianping.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("/admin/seller")
@RequestMapping("/admin/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index() {
        List<SellerModel> sellerModelList = sellerService.selectAll();

        ModelAndView modelAndView = new ModelAndView("admin/seller/index.html");
        modelAndView.addObject("data", sellerModelList);
        modelAndView.addObject("CONTROLLER_NAME", "seller");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }
}
