package com.service.impl;

import com.bean.User;
import com.dao.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestMSvc {

    @Autowired
    private IUserDAO userDao;

    public void test(){
        List<User> user = userDao.qryAll();
        System.out.println("用户长度："+user.size());
    }

}
