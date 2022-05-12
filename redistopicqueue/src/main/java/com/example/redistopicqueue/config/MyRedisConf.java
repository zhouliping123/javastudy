package com.example.redistopicqueue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.example.redistopicqueue.Receiver;

@Configuration
public class MyRedisConf {
	 @Bean
	    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
	                                                   MessageListenerAdapter listenerAdapter){
	        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
	        container.setConnectionFactory(connectionFactory);
	        container.addMessageListener(listenerAdapter,new PatternTopic("mytopic"));
	        return container;
	    }
	 
	 @Bean
	    public MessageListenerAdapter listenerAdapter(){
	        return new MessageListenerAdapter(new Receiver(),"receiveMessage");
	    }
}
