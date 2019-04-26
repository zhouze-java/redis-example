package com.redis.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 周泽
 * @date Create in 11:40 2019/4/26
 * @Description String类型的键值对工具类
 */
@Slf4j
@Component
public class RedisStringUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 写入redis缓存,没有过期时间
     * @param key key
     * @param value value
     */
    public void set(final String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 写入redis缓存,过期时间单位是秒
     * @param key key
     * @param value value
     * @param expire 过期时间(单位是秒)
     */
    public void setex(final String key, String value, Long expire){
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 写入redis缓存,过期时间单位是毫秒
     * @param key key
     * @param value value
     * @param expire 过期时间(单位是毫秒)
     */
    public void psetex(final String key, String value, Long expire){
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.MILLISECONDS);
    }

    /**
     * 读取缓存
     * @param key key
     * @return result
     */
    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 判断某个key是否存在
     * @param key key
     * @return 是否存在
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据key删除数据
     * @param key key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除
     * @param keys key
     */
    public void remove(final  String ... keys){
        for (String key : keys) {
            if (exists(key)) {
                redisTemplate.delete(key);
            }
        }
    }

}
