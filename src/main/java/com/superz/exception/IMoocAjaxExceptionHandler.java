package com.superz.exception;

import com.superz.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest request, Exception e){

        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }
}
