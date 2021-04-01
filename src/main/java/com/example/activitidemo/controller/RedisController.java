package com.example.activitidemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.activitidemo.entity.dto.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisController {

    @Autowired
//    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RedisTemplate<String,Days> daysRedisTemplate;

    @PostMapping(value = "/setKey")
    public Map<String,String> setKey(@RequestParam("key") String key, @RequestParam("value") String value){
        //设置序列化方式
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.opsForValue().set(key,value);
        Map<String, String> map = new HashMap<>();
        map.put(key,value);
        System.out.println("key:" + key + ",value:" + redisTemplate.opsForValue().get(key));
        return map;
    }

    @PostMapping(value = "/setDays")
    public Days setDays(@RequestBody Days days){
//        Days d = (Days) JSONObject.parse(JSONObject.toJSONString(days));
        daysRedisTemplate.opsForValue().set("days",days);
        System.out.println("days:" + daysRedisTemplate.opsForValue().get("days"));
        return daysRedisTemplate.opsForValue().get("days");
    }


}
