package com.consts;

import java.util.HashMap;
import java.util.Map;

public class BusiConstant {
    //系统异常枚举
    private static final Map<Integer,String> ROO_SYS_ERROR_MAPPER = new HashMap<Integer,String>();
    static{
        ROO_SYS_ERROR_MAPPER.put(101, "服务接口异常");
        ROO_SYS_ERROR_MAPPER.put(102, "服务接口入参异常");
    }
    public static String getSysErrorValue(int code) {
        return ROO_SYS_ERROR_MAPPER.get(code);
    }
}
