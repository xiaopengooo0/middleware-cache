package com.std.redis.example.message.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @Author: xiaopeng
 * @Description: TODO
 * @DateTime: 2025/11/3 下午3:15 星期一
 **/
@Component
public class MessageListenerImpl implements MessageListener{
    private static final Logger log = LoggerFactory.getLogger(MessageListenerImpl.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();
        log.info("监听到的消息：" + new String(body));
        log.info("监听到的频道：" + new String(message.getChannel()));
        log.info("监听到的模式：" + new String(pattern));
        log.info("--------------------------------------------------");

        // 可以将消息保存到数据库中，或者发送给其他服务进行处理，或者进行其他处理，具体根据业务需求
        log.info("消息处理完毕");
    }
}
