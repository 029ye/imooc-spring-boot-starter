package com.superz.exception;

import com.superz.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class IMoocExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "error";

    /*
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, Exception e){

        e.printStackTrace();

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(IMOOC_ERROR_VIEW);
        return mav;
    }*/


    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, Exception e){

        e.printStackTrace();

        if (isAjax(request)) {
            return IMoocJSONResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
        }
    }

    public static boolean isAjax(HttpServletRequest request){
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest"
                .equals(request.getHeader("X-Requested-With")));
    }
}
