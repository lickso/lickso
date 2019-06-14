package com.exception;

import java.util.Map;

public class RooException extends Exception {
	public transient Map<String, Object> params;
	public int exceptionCode;
	private static final long serialVersionUID = 1L;

	public RooException() {
		this("服务接口异常");
	}

	public RooException(String msg) {
		super(msg);
	}

	public RooException(Throwable cause) {
		this("服务接口异常", cause);
	}

	public RooException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public int getExceptionCode() {
		return this.exceptionCode;
	}
}
