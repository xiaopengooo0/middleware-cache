package com.std.redis.example.analise.controller;

import com.std.redis.example.analise.entity.UserOnlineDuration;
import com.std.redis.example.analise.service.OnlineDurationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/4 上午9:18 星期二
 **/
@RestController
public class AnaliseController {

    @Resource
    private OnlineDurationService onlineDurationService;

    @RequestMapping("/user/{userId}/login")
    public ResponseEntity<String> login(@PathVariable String userId) {
        onlineDurationService.addOnlineUser(userId);
        return ResponseEntity.ok("用户" + userId + "登录成功");
    }

    @RequestMapping("/user/{userId}/logout")
    public ResponseEntity<String> logout(@PathVariable String userId) {
        onlineDurationService.updateOnlineDuration(userId);
        return ResponseEntity.ok("用户" + userId + "登出成功");
    }

    @RequestMapping("/top/{top}")
    public ResponseEntity<Set<UserOnlineDuration>> getTopOnlineDuration(@PathVariable int top) {
        return ResponseEntity.ok(onlineDurationService.getTopOnlineDuration(top));
    }
}
