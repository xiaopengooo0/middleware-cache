package com.std.redis.example.count.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/3 下午2:10 星期一
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    private String id;

    private String title;

    private Integer likeCount;
}
