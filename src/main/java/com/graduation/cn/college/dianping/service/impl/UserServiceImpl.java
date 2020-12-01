package com.graduation.cn.college.dianping.service.impl;

import com.graduation.cn.college.dianping.common.BusinessException;
import com.graduation.cn.college.dianping.common.EmBusinessError;
import com.graduation.cn.college.dianping.dal.UserModelMapper;
import com.graduation.cn.college.dianping.model.UserModel;
import com.graduation.cn.college.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }


    @Transactional
    @Override
    public UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        registerUser.setPassword(encodeByMd5(registerUser.getPassword()));
        registerUser.setCreatedAt(new Date());
        registerUser.setUpdatedAt(new Date());

        try {
            userModelMapper.insertSelective(registerUser);
        }catch (DuplicateKeyException ex) {
            throw new BusinessException(EmBusinessError.REGISTER_DUP_FAIL);
        }
        return getUser(registerUser.getId());
    }


    private String encodeByMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder =  new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes("utf-8")));
    }
}
