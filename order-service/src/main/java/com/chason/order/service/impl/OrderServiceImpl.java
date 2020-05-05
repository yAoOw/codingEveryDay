package com.chason.order.service.impl;

import com.chason.order.config.RedisLock;
import com.chason.order.domain.MyOrder;
import com.chason.order.mapper.MyOrderMapper;
import com.chason.order.service.OrderService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

/**
 * @author Administrator
 * Created by Administrator on 2020/5/3
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final MyOrderMapper myOrderMapper;

    private final JedisPool jedisPool;

    private String lockKey ="ORDER_KEY";
    @Autowired
    public OrderServiceImpl(MyOrderMapper myOrderMapper,JedisPool jedisPool) {
        this.myOrderMapper = myOrderMapper;
        this.jedisPool =jedisPool;
    }

    @Override
    public void insertOne(MyOrder order) {
        log.info("order param: {}",order);
        String requestId = UUID.randomUUID().toString();
        Jedis jedis = jedisPool.getResource();
        boolean result = RedisLock.tryGetDistributedLock(jedis, lockKey, requestId, 30000);
        if(result) {
            myOrderMapper.insertSelective(order);
        }
        RedisLock.releaseDistributedLock(jedis,lockKey,requestId);
    }
}
