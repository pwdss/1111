package com.liu.service.impl;


import com.liu.dao.UserDao;
import com.liu.pojo.User;
import com.liu.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserSerivce {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> getuserlist() {
        return userDao.getuserlist();
    }
}
