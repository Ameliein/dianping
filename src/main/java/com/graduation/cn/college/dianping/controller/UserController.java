package com.graduation.cn.college.dianping.controller;

import com.graduation.cn.college.dianping.common.*;
import com.graduation.cn.college.dianping.model.UserModel;
import com.graduation.cn.college.dianping.request.RegisterReq;
import com.graduation.cn.college.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller("/user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonRes getUser(@RequestParam(name = "id")Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if (userModel == null) {
//            return CommonRes.create(new CommonError(EmBusinessError.NO_OBJECT_FOUND),"failure");
            throw new BusinessException(EmBusinessError.NO_OBJECT_FOUND);
        } else {
            return CommonRes.create(userModel);
        }
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        String name = "harry";
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name",name);
        return modelAndView;
    }

    @RequestMapping("/register")
    @ResponseBody
    public CommonRes register(@RequestBody @Valid RegisterReq registerReq, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }

        UserModel registerUser = new UserModel();
        registerUser.setTelphone(registerReq.getTelphone());
        registerUser.setPassword(registerReq.getPassword());
        registerUser.setNickName(registerReq.getNickName());
        registerUser.setGender(registerReq.getGender());
        UserModel resUserModel =  userService.register(registerUser);
        return CommonRes.create(resUserModel);
    }

}
