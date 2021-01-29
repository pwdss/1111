package com.liu.service.impl;


import com.liu.Tools.MD5;
import com.liu.Tools.RedisApi;
import com.liu.dao.UserDao;
import com.liu.pojo.User;
import com.liu.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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

    @Override
    public void InfoMail(User user) {
        /**模拟从表单内获取内容*/
        String infoMessage= Integer.toString(MD5.getRandomCode());    //验证码四位数字 0~9999
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setPort(25);
        mailSender.setUsername("1419932113@qq.com");
        mailSender.setPassword("SPKRTDXDUUZXPXNF");
        mailSender.setDefaultEncoding("UTF-8");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1419932113@qq.com");
        simpleMailMessage.setSubject("【i旅行】请激活您的账户");
        simpleMailMessage.setTo(user.getUsercode());
        simpleMailMessage.setText("激活码:"+MD5.getMd5(infoMessage,32));
        mailSender.send(simpleMailMessage);
        System.out.println("发送成功");
        System.out.println("目标邮箱===>"+user.getUsercode());
        System.out.println("验证码===>"+infoMessage);
        System.out.println("验证码加密(这个验证码是要保存在redis内)===>"+MD5.getMd5(infoMessage,32));


    }

}
