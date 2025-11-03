package com.std.redis.example.count.controller;

import com.std.redis.example.count.entity.Article;
import com.std.redis.example.count.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/3 下午2:23 星期一
 **/
@RestController
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/addArticleViewCount")
    public ResponseEntity<String> addArticleViewCount(String articleId) {
        // 添加文章浏览量
        articleService.addArticleViewCount(articleId);
        return ResponseEntity.ok("添加文章浏览量成功");
    }

    @RequestMapping("/getTopLikedArticles")
    public ResponseEntity<List<Article>> getTopLikedArticles(int topN) {
        List<Article> topArticles = articleService.getTopLikedArticles(topN);
        return ResponseEntity.ok(topArticles);
    }
}
