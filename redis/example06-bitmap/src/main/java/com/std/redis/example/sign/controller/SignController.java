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
        try {
            return ResponseEntity.ok(userSignService.sign(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping("/supplySign")
    public ResponseEntity<?> supplySign(String userId,String signDate) {
        try {
            return ResponseEntity.ok(userSignService.supplySign(userId,signDate));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping("signCount")
    public ResponseEntity<?> signCount(String userId,String signDate) {
        try {
            return ResponseEntity.ok(userSignService.getSignCount(userId,signDate));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
