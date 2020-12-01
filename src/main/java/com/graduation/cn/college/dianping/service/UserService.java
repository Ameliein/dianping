package com.graduation.cn.college.dianping.service;

import com.graduation.cn.college.dianping.common.BusinessException;
import com.graduation.cn.college.dianping.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    UserModel getUser(Integer id);

    UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;
}
