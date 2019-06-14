package com.exception;

import com.consts.BusiConstant;

import java.util.Map;


public class RooIntfServiceException extends RooException{
	private static final long serialVersionUID = 1L;

	public RooIntfServiceException() {
		this(BusiConstant.getSysErrorValue(101));
		this.exceptionCode = 101;
	}

	public RooIntfServiceException(int errCode) {
		this(BusiConstant.getSysErrorValue(errCode));
		this.exceptionCode = errCode;
	}
	
	public RooIntfServiceException(int errCode,String msg) {
		super(msg);
		this.exceptionCode = errCode;
	}
	
	public RooIntfServiceException(String msg) {
		super(msg);
		this.exceptionCode = 101;
	}

	public RooIntfServiceException(Throwable cause) {
		this(BusiConstant.getSysErrorValue(101), cause);
		this.exceptionCode = 101;
	}

	public RooIntfServiceException(String msg, Throwable cause) {
		super(msg, cause);
		this.exceptionCode = 101;
	}

	public RooIntfServiceException(Map<String, Object> params) {
		this();
		this.exceptionCode = 101;
		this.params = params;
	}

	public RooIntfServiceException(String msg, Map<String, Object> params) {
		this(msg);
		this.exceptionCode = 101;
		this.params = params;
	}

	public RooIntfServiceException(String msg, Map<String, Object> params, Throwable cause) {
		this(msg, cause);
		this.exceptionCode = 101;
		this.params = params;
	}

	public RooIntfServiceException(Map<String, Object> params, Throwable cause) {
		this(cause);
		this.exceptionCode = 101;
		this.params = params;
	}
}
