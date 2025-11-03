package com.std.redis.example.count.service;

import com.std.redis.example.count.entity.Article;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/3 下午2:11 星期一
 **/
@Service
public class ArticleService {


    @Resource
    private RedisTemplate redisTemplate;


    public void addArticleViewCount(String articleId) {
        String key = "article:" + articleId+":likeCount";
        redisTemplate.opsForValue().increment(key);
    }


    public List<Article> getTopLikedArticles(int topN) {
        // 获取topN个点赞数最多的文章
        Set<String> articleIds = redisTemplate.keys("article:*:likeCount");
        List<Article> topArticles = new ArrayList<>();
        for (String id : articleIds) {
            int likeCount = (Integer) redisTemplate.opsForValue().get(id);
            Article article = new Article();
            article.setId(id.replace("article:", "").replace(":likeCount", ""));
            article.setTitle("文章标题待查询");
            article.setLikeCount(likeCount);
            topArticles.add(article);
        }
        // 根据点赞数排序
        topArticles.sort((a1, a2) -> a2.getLikeCount() - a1.getLikeCount());
        return topArticles.subList(0, topN);
    }



}
