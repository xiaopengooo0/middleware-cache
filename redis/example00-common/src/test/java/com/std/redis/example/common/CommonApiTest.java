package com.std.redis.example.common;

import com.std.redis.example.common.entity.Book;
import com.std.redis.example.common.service.IBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/3 上午10:57 星期一
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommonApiTest {


    @Resource
    private IBookService bookService;


    @Test
    public void testGetBookById() {
        for (int i = 1; i <= 10; i++) {
             bookService.getBookById(i%5);
        }
    }
}
