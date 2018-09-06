package com.superz.controller;

import com.superz.pojo.Girl;
import com.superz.pojo.IMoocJSONResult;
import com.superz.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @RequestMapping("test")
    public IMoocJSONResult test(){

        strRedis.opsForValue().set("imooc-cache", "hello 慕课网～～～");

        Girl girl = new Girl();
        girl.setAge(21);
        girl.setCupSize("D");
        girl.setId(11);

        strRedis.opsForValue().set("json:girl", JsonUtils.objectToJson(girl));
        Girl jsonGirl = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:girl"), Girl.class);

        return IMoocJSONResult.ok(jsonGirl);
    }
}
