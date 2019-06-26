package com.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.bean.AdminBean;
import com.result.CodeMsg;
import com.result.Result;
import com.service.interfaces.IRooAdminSV;
import com.utils.RooCommonUtils;
import com.utils.UUIDUtil;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class RooAdminController extends BaseController{
    private static final transient Logger logger = Logger.getLogger(RooAdminController.class);

    @Autowired
    IRooAdminSV adminSV;

    //管理员登录
    @RequestMapping(value="/login")
    @ResponseBody
    public Result login(HttpServletRequest request) throws Exception {

        JSONObject jsonObj = super.getInputObject(request);
        JSONObject rtnObj = new JSONObject();
        String accessNum = RooCommonUtils.getJsonValue(jsonObj,"accessNum");
        String password = RooCommonUtils.getJsonValue(jsonObj,"password");
        if(StringUtils.isEmpty(accessNum) || StringUtils.isEmpty(password)){
            return Result.error(new CodeMsg("管理员登录用户手机号，密码不可为空！"));
        }

        Map inParam = new HashMap();
        inParam.put("accessNum",accessNum);
        inParam.put("password",password);
        AdminBean[] adminBeans = adminSV.qryAdminByAccessNumAndPswd(inParam);

        if(ArrayUtils.isEmpty(adminBeans)){
            return Result.error(new CodeMsg("不存在该管理员！"));
        }else{
            rtnObj.put("token", UUIDUtil.uuid());
            rtnObj.put("token", "18543124169");
            return Result.success(rtnObj);
        }
    }

    //管理员信息
    @RequestMapping(value="/info", method= RequestMethod.GET)
    @ResponseBody
    public Result getInfo(HttpServletRequest request) throws Exception {

        JSONObject jsonObj = super.getInputObject(request);
        JSONObject rtnObj = new JSONObject();
        JSONObject rtnMsg = new JSONObject();

        String token = RooCommonUtils.getJsonValue(jsonObj,"token");


        Object[] roles = {"admin","editor"};
        rtnObj.put("roles", roles);
        rtnObj.put("name", "杨胜");
        rtnObj.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        rtnObj.put("introduction", "超级管理员");
        rtnMsg.put("18543124169",rtnObj);
        return Result.success(rtnObj);

        /*if(StringUtils.isEmpty(token)){
            return Result.error(new CodeMsg("非法请求，拒绝访问！"));
        }else{
            rtnObj.put("roles", "admin");
            rtnObj.put("name", "杨胜");
            rtnObj.put("avatar", "yangsheng");
            rtnObj.put("introduction", "超级管理员");
            return Result.success(rtnObj);
        }*/
    }
}
