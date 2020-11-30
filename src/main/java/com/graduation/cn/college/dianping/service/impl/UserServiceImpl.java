package com.graduation.cn.college.dianping.service.impl;

import com.graduation.cn.college.dianping.dal.UserModelMapper;
import com.graduation.cn.college.dianping.model.UserModel;
import com.graduation.cn.college.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }
}
