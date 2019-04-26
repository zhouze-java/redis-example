package com.redis.example;

import com.redis.example.model.User;
import com.redis.example.utils.RedisStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RedisStringUtil redisStringUtil;

    @Test
    public void test(){
        boolean result = redisStringUtil.exists("k1");
        log.info(String.valueOf(result));

        redisStringUtil.set("k2", "v1");

        String v2 = redisStringUtil.get("k2");
        log.info(v2);
    }

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1() {
        User user = new User(1L, "张三", 18);

        redisTemplate.opsForValue().set("user1", user);

        User user1 = (User)redisTemplate.opsForValue().get("user1");

        log.info("用户名:{}", user1.getName());
    }
}
