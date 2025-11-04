package com.std.redis.example.lock.controller;

import com.std.redis.example.lock.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/4 上午11:34 星期二
 **/
@RestController
public class ReportController {

    @Resource
    private ReportService reportService;

    @GetMapping("/daily")
    public ResponseEntity<String> generateDailyReport() {
        reportService.generateDailyReport();
        return ResponseEntity.ok("Daily report generation triggered.");
    }
}
