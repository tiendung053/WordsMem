package com.dailycodebuffer.user.service;

public interface RedisService {


    public Object get(String key, String hashKey);

    public void set(String key, String hashKey, Object object, int time);
}
