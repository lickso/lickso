package com.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.bean.AdminBean;
import com.result.CodeMsg;
import com.result.Result;
import com.service.interfaces.IRooAdminSV;
import com.utils.RooCommonUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class RooAdminController extends BaseController{
    private static final transient Logger logger = Logger.getLogger(RooAdminController.class);

    @Autowired
    IRooAdminSV adminSV;

    //管理员登录
    @RequestMapping(value="/login")
    @ResponseBody
    public Result login(HttpServletRequest request) throws Exception {

        JSONObject jsonObj = super.getInputObject(request);
        String accessNum = RooCommonUtils.getJsonValue(jsonObj,"accessNum");
        String password = RooCommonUtils.getJsonValue(jsonObj,"password");

        if(StringUtils.isEmpty(accessNum) || StringUtils.isEmpty(password)){
            return Result.error(new CodeMsg(-999, "管理员登录用户手机号，密码不可为空！"));
        }

        Map inParam = new HashMap();
        inParam.put("accessNum",accessNum);
        inParam.put("password",password);
        AdminBean[] adminBeans = adminSV.qryAdminByAccessNumAndPswd(inParam);

        if(ArrayUtils.isEmpty(adminBeans)){
            return Result.error(new CodeMsg(-999, "不存在该管理员！"));
        }else{
            return Result.success(adminBeans[0]);
        }
    }
}
