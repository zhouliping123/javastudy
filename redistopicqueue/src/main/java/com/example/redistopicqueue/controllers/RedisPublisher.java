package com.example.redistopicqueue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisPublisher {
    @Autowired
    private StringRedisTemplate template;
	@RequestMapping("publish")
    public String publish(){        
        for(int i=1;i<=10;i++){
        	
            template.convertAndSend("mytopic", "这是我发第"+i+"条的消息...");
        }
        return "结束";
    }
}
