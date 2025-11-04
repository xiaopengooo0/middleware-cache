package com.std.redis.example.analise.service;

import com.std.redis.example.analise.entity.UserOnlineDuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/4 上午9:13 星期二
 **/
@Service
public class OnlineDurationService {


    @Resource
    private RedisTemplate redisTemplate;

    @SuppressWarnings("unchecked")
    public void addOnlineUser(String userId) {
        // 记录当前登陆时间
        redisTemplate.opsForValue().set("user:login:" + userId, System.currentTimeMillis());
    }
    @SuppressWarnings("unchecked")
    public void updateOnlineDuration(String userId) {
        long duration = System.currentTimeMillis() - (long)redisTemplate.opsForValue().get("user:login:" + userId);
        redisTemplate.opsForZSet().incrementScore("user:online:duration", userId, duration);
    }

    public Set<UserOnlineDuration> getTopOnlineDuration(int  top) {
        Set<String> set = redisTemplate.opsForZSet().reverseRange("user:online:duration", 0, top - 1);
        HashSet<UserOnlineDuration> userOnlineDurations = new HashSet<>();
        for (String item : set) {
            UserOnlineDuration userOnlineDuration = new UserOnlineDuration();
            Double score = redisTemplate.opsForZSet().score("user:online:duration", item);
            userOnlineDuration.setUserId(item);
            userOnlineDuration.setDuration(score.longValue()/1000);
            userOnlineDurations.add(userOnlineDuration);

        }
        return userOnlineDurations;
    }
}
