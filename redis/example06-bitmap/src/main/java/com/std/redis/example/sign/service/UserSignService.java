package com.std.redis.example.sign.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/4 下午5:12 星期二
 **/
@Slf4j
@Service
public class UserSignService {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String GLOBAL_ID_KEY = "global:user:id";
    private static final String ID_MAP_KEY = "user:id:map";      // 原始ID → 整数ID
    private static final String ID_REV_KEY = "user:id:rev";

    // 使用构造器注入
    public UserSignService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public boolean sign(String userId){
        LocalDateTime now = LocalDateTime.now();
        String key = buildSignKey(userId, now);
        int dayOfMonth = now.getDayOfMonth();
        // 使用原子操作确保幂等性：先设置再检查之前是否已设置，该方法会返回设置之前的值
        // 如果返回false，表示之前未签到，现在已签到
        // 如果返回true，表示之前已签到
        boolean wasAlreadySigned = Boolean.TRUE.equals(redisTemplate.opsForValue().setBit(key, dayOfMonth - 1, true));
        log.info("用户{}在{}签到，结果：{}", userId, now, !wasAlreadySigned);
        if (wasAlreadySigned) {
            throw new RuntimeException("已经签到过了");
        }
        return true;
    }

    public boolean checkSign(String userId){
        LocalDateTime now = LocalDateTime.now();
        String key = buildSignKey(userId, now);
        int dayOfMonth = now.getDayOfMonth();
        return Boolean.TRUE.equals(redisTemplate.opsForValue().getBit(key, dayOfMonth - 1));
    }



    /**
     * 构建签到key
     * @param userId
     * @param now
     * @return
     */
    private String buildSignKey(String userId, LocalDateTime now) {
        String month  = now.format(DateTimeFormatter.ofPattern("yyyyMM"));
        return String.format("user:sign:%s:%s", userId, month);
    }


}
