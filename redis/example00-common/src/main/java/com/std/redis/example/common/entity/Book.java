package com.std.redis.example.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/3 上午10:49 星期一
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
}
