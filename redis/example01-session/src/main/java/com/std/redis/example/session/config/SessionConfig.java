package com.std.redis.example.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer; // 使用FastJson
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.DefaultCookieSerializer;
// 或者使用Jackson：import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
@EnableRedisHttpSession // 核心注解，启用Redis存储Session
public class SessionConfig {
    
    // 配置JSON序列化器替代默认的JDK序列化，便于阅读和管理
    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        // 使用FastJson
//        return new GenericFastJsonRedisSerializer();
//         或者使用Jackson
        return new GenericJackson2JsonRedisSerializer();
    }
    
    // (可选) 如果遇到跨项目共享Session问题，可配置Cookie路径
    @Bean
    public DefaultCookieSerializer defaultCookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookiePath("/"); // 设置为根路径，方便同域名下不同项目共享
        return serializer;
    }
}