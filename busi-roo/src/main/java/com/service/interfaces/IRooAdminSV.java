package com.service.interfaces;

import com.bean.AdminBean;
import java.util.Map;

public interface IRooAdminSV {

    //根据管理员手机号码，密码查询管理员信息
    public AdminBean[] qryAdminByAccessNumAndPswd(Map inParam) throws Exception;

}
