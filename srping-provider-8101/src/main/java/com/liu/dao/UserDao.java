package com.liu.dao;

import com.liu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
        //用户查询方法
        public List<User> getuserlist();
}
