package com.gw.redis.learn.redislearn.service;

import com.gw.redis.learn.redislearn.entity.User;

public interface GameShopService {
    boolean listItem(Integer itemid,Integer sellerId,Double price);
    String getValue(String key);
    void setUser(String key,User user);
    User getUser(String key);
}
