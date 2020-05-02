package com.chason.redis_unique_id.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * Created by Administrator on 2020/5/2
 */
@Service
public class PrimaryKeyService {

    private final RedisTemplate redisTemplate;

    @Autowired
    public PrimaryKeyService(RedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
    }

    public Long getId(){

        String key = "DEMO_ORDER_ID_";

        return redisTemplate.opsForValue().increment(key,1);
    }
}
