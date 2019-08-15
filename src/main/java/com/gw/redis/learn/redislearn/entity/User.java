package com.gw.redis.learn.redislearn.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable{
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Double funds;
}
