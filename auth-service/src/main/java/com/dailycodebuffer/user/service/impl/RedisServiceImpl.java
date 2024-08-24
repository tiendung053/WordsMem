package com.dailycodebuffer.user.service.impl;

import com.dailycodebuffer.user.service.RedisService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Gson gson;


    public Object get(String key, String hashKey) {
        return this.redisTemplate.opsForHash().get(key,hashKey);
    }

    public void set(String key, String hashKey, Object object, int time) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, hashKey, gson.toJson(object));
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }
}
