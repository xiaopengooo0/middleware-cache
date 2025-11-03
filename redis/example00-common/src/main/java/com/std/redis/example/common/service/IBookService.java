package com.std.redis.example.common.service;

import com.std.redis.example.common.entity.Book;

/**
 * @Author: xiaopeng
 * @Description:
 * @DateTime: 2025/11/3 上午10:50 星期一
 **/
public interface IBookService {
    Book getBookById(Integer id);
}
