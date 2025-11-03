package com.std.redis.example.message.service;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/3 下午3:16 星期一
 **/
@Service
public class OrderService {

    @Resource
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    @Resource
    private RedisTemplate<String, String> redisTemplate;


    public Mono<Void> placeOrder(String orderId) {
        return reactiveRedisTemplate.convertAndSend("order-channel", orderId).then();
    }

    public void sendOrder(String orderId) {
        redisTemplate.convertAndSend("order-channel", orderId);
    }
}
