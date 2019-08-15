package com.gw.redis.learn.redislearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gw.redis.learn.redislearn.controller","com.gw.redis.learn.redislearn.impl","com.gw.redis.learn.redislearn.config"})
public class RedisLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisLearnApplication.class, args);
	}

}
