package com.superz.controller;

import com.superz.pojo.IMoocJSONResult;
import com.superz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

// @Controller
@RestController             // @RestController = @Controller + @ResponseBody
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    // @ResponseBody
    public User getUser(){

        User user = new User();
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDesc("热部署测试");
        user.setName("imooc");
        user.setPassword("imooc");

        return user;
    }

    @RequestMapping(value = "/getUserJson", method = RequestMethod.GET)
    // @ResponseBody
    public IMoocJSONResult getUserJson(){

        User user = new User();
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDesc(null);
        user.setName("imooc");
        user.setPassword("imooc");

        return IMoocJSONResult.ok(user);
    }
}
