package com.gw.redis.learn.redislearn.controller;

import com.gw.redis.learn.redislearn.entity.User;
import com.gw.redis.learn.redislearn.service.GameShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private GameShopService gameShop;
    @GetMapping("/get/{key}")
    public Mono<String> getValue(@PathVariable(name = "key",required = true) String key){
        return Mono.just(gameShop.getValue(key));
    }
    @PostMapping("/setUser")
    public void setUser(@RequestBody(required = true) User user){
        Long id = gameShop.getAndIncrUserId();
        user.setId(id);
        gameShop.setUser("Users:"+id,user);
    }
    @PostMapping("/getUser")
    public User getUser(@RequestBody(required = true) String key){
        return Optional.ofNullable(gameShop.getUser(key)).orElse(null);
    }
}
