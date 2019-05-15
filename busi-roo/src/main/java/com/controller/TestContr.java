package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.service.impl.TestMSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class TestContr {
    @Autowired
    TestMSvc userSV;
    /**
     * 查询所有用户
     *
     * @author yangsheng
     */
    @RequestMapping("/qryAllUser")
    @ResponseBody
    public String qryAllUser() {

        userSV.test();
        return "this is real";

    }

    /**
     * 获取测试数据-用于测试
     * @return
     */
    @RequestMapping("/getTestMsg")
    @ResponseBody
    public String getTestMsg() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name","yangsheng");
        jsonObject.put("password","ys12345");
        return jsonObject.toJSONString();
    }

}

