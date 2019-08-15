package com.gw.redis.learn.redislearn.impl;

import com.gw.redis.learn.redislearn.entity.User;
import com.gw.redis.learn.redislearn.service.GameShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
@Service("gameShop")
public class GameShopServiceImpl implements GameShopService {
    private final static String KEY_USER_ID = "userId";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource(name = "redisTemplate")
    private HashOperations<String, String,Object> hashOperations;
    private HashMapper<Object,String,Object> mapper = new Jackson2HashMapper(false);
    @Override
    public boolean listItem(Integer itemid, Integer sellerId, Double price) {
        return false;
    }

    @Override
    public String getValue(String key) {
        return Optional.ofNullable(stringRedisTemplate.opsForValue().get(key)).orElse("nil");
    }

    @Override
    public void setUser(String key,User user) {
        hashOperations.putAll(key,mapper.toHash(user));
    }

    @Override
    public User getUser(String key) {
        return (User) mapper.fromHash(hashOperations.entries(key));
    }

    @Override
    public Long getAndIncrUserId() {
        return stringRedisTemplate.opsForValue().increment(KEY_USER_ID);
    }
}
