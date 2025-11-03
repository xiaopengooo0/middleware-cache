package com.std.redis.example.common.service.impl;

import com.std.redis.example.common.entity.Book;
import com.std.redis.example.common.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/3 上午10:50 星期一
 **/
@Service
public class BookServiceImpl implements IBookService {

    private static final Map<Integer, Book> bookMap = Map.of(
            1, new Book(1, "《SpringBoot 1.0开发指南》", "小王"),
            2, new Book(2, "《SpringBoot 2.0开发指南》", "小王"),
            3, new Book(3, "《SpringBoot 3.0开发指南》", "小王"),
            4, new Book(4, "《SpringBoot 4.0开发指南》", "小王")
    );
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);


    @Resource
    private RedisTemplate<String, Book> redisTemplate;


    @Override
    public Book getBookById(Integer id) {

        Book book  = redisTemplate.opsForValue().get("book:" + id);
        if (book != null) {
            log.info("从Redis中获取数据：{}", book);
            return book;
        }
        book = bookMap.get(id);
        if (book != null) {
            log.info("从Map中获取数据：{}, 并添加缓存", book);
            // 也可以添加过期时间
            redisTemplate.opsForValue().set("book:" + id, book);
            return book;
        }

        log.info("数据不存在，返回null");

        return book;
    }
}
