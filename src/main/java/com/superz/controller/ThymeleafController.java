package com.superz.controller;

import com.superz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("name", "thymeleaf-SuperZ");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(){
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap map){

        User user = new User();
        user.setName("superadmin");
        user.setAge(18);
        user.setPassword("SuperZ");
        user.setBirthday(new Date());
        user.setDesc("<font color='green'><b>hello</b></font>");

        map.addAttribute("user", user);

        User user1 = new User();
        user1.setName("imooc");
        user1.setAge(19);
        user1.setBirthday(new Date());
        user1.setPassword("imooc");

        User user2 = new User();
        user2.setName("LeeCX");
        user2.setAge(17);
        user2.setBirthday(new Date());
        user2.setPassword("LeeCX");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);

        map.addAttribute("userList", userList);

        return "thymeleaf/test";
    }

    @RequestMapping("postform")
    public String postform(User user){

        System.out.println("姓名" + user.getName());
        System.out.println("年龄" + user.getAge());

        return "redirect:/th/test";
    }
}
