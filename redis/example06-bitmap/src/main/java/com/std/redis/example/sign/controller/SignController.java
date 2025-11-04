package com.std.redis.example.sign.controller;

import com.std.redis.example.sign.service.UserSignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: xiaopeng
 * @Description:
 * @DateTime: 2025/11/4 下午5:26 星期二
 **/
@RestController
public class SignController {

    @Resource
    private UserSignService userSignService;


    @RequestMapping("/sign")
    public ResponseEntity<?> sign(String userId) {
        return ResponseEntity.ok(userSignService.sign(userId));
    }
}
