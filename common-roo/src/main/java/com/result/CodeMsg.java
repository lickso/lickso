package com.result;

public class CodeMsg {
	private int code;
	private String msg;
	
	//定义系统错误
	public static CodeMsg INTF_SV_ERROR = new CodeMsg(101, "服务接口异常");
	public static CodeMsg INTF_PARAM_IN_ERROR = new CodeMsg(102, "服务接口入参异常");

	//通用返回
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(-999, "服务端异常");

	//失败通用返回
	public CodeMsg(String msg) {
		this.code = -999;
		this.msg = msg;
	}

	public CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}


	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
