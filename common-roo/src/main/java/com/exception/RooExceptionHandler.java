package com.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*import com.result.CodeMsg;
import com.result.Result;
import com.utils.LocalConstants;*/

@ControllerAdvice
@ResponseBody
public class RooExceptionHandler {
	
	private static final transient Logger logger = Logger.getLogger(RooExceptionHandler.class);
	
	/*@ExceptionHandler(value=Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){

		if(e instanceof RooIntfServiceException) {
			RooIntfServiceException ex = (RooIntfServiceException)e;
			logger.info("服务异常:"+"异常编码:【"+ex.getExceptionCode()+"】异常信息【"+ex.getMessage()+"】.");
			return Result.error(new CodeMsg(ex.getExceptionCode(),LocalConstants.getSysErrorValue(ex.getExceptionCode())));
		}else {
			return Result.error(CodeMsg.INTF_SV_ERROR);
		}
	}*/
}
