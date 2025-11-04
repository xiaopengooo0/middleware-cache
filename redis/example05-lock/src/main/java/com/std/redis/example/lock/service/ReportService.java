package com.std.redis.example.lock.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/4 上午11:32 星期二
 **/
@Service
public class ReportService {

    private static final Logger log = LoggerFactory.getLogger(ReportService.class);
    @Resource
    private RedissonClient redissonClient;


    public void generateDailyReport() {
        RLock lock = redissonClient.getLock("dailyReportLock");
        try {
            // 尝试获取锁，最多等待3秒，锁的自动过期时间设置为10秒
            if (lock.tryLock(3, 10, TimeUnit.SECONDS)) {
                // 执行生成日报表的操作
                log.info("Generating daily report...");
                // 模拟长时间运行的任务
                TimeUnit.SECONDS.sleep(5);
                log.info("Daily report generated.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
