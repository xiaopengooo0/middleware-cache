package com.std.redis.example.session.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class TestController {

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", "Lucy");
        session.setAttribute("age", 20);
        return "Session设置成功，sessionId: " + session.getId();
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String userName = (String) session.getAttribute("userName");
            Integer age = (Integer) session.getAttribute("age");
            return "用户名: " + userName + ", 年龄: " + age + ", sessionId: " + session.getId();
        } else {
            return "Session不存在";
        }
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 使Session失效
        }
        return "登出成功";
    }
}