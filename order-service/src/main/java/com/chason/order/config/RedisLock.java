package com.chason.order.config;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @author Administrator
 * Created by Administrator on 2020/5/5
 */
public class RedisLock {

    private static final String lOCK_SUCCESS ="OK";
    private static final String set_if_not_exist ="NX";
    private static final String set_with_expire_time ="PX";
    private static final Long RELEASE_SUCCESS = 1L;


    public static boolean tryGetDistributedLock(Jedis jedis,String lockKey,String requestId,int expireTime){
        String result = jedis.set(lockKey,requestId,set_if_not_exist,set_with_expire_time,expireTime);

        if(lOCK_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }
    public static boolean releaseDistributedLock(Jedis jedis,String lockKey,String requestId){
        String script ="if redis.call('get', KEYS[1]) == ARGV[1] then return " +
                "redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if(RELEASE_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }
}
