package com.std.redis.example.analise.entity;

import lombok.Data;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/4 上午9:34 星期二
 **/
@Data
public class UserOnlineDuration {
    private String userId;
    private long duration;
}
