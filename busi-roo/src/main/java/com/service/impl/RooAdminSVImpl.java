package com.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.bean.AdminBean;
import com.dao.IAdminDAO;
import com.service.interfaces.IRooAdminSV;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RooAdminSVImpl implements IRooAdminSV {
    @Autowired
    IAdminDAO adminDAO;

    //根据管理员手机号码，密码查询管理员信息
    public AdminBean[] qryAdminByAccessNumAndPswd(Map inParam) throws Exception{
        String accessNum = MapUtils.getString(inParam,"accessNum","");
        String password = MapUtils.getString(inParam,"password","");

        if(StringUtils.isEmpty(accessNum) || StringUtils.isEmpty(password)){
            throw new Exception("查询管理员，手机号码，密码不可缺失！");
        }
        return adminDAO.qryAdminByAccessNumAndPswd(accessNum,password);
    }
}
