package com.std.redis.example.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/4 上午11:21 星期二
 **/
@SpringBootApplication
public class LockedApplication {
    public static void main(String[] args) {
        SpringApplication.run(LockedApplication.class, args);
    }
}
