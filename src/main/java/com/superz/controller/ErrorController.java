package com.superz.controller;

import com.superz.pojo.IMoocJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error(){

        int a = 1 / 0;

        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror(){

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    public IMoocJSONResult getAjaxerror(){

        int a = 1 / 0;

        return IMoocJSONResult.ok();
    }
}
