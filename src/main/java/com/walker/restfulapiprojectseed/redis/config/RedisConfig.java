package com.walker.restfulapiprojectseed.redis.config;

import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redisTemplate实例化
 * Created by wangshun on 2018/3/24
 **/
@Configuration
public class RedisConfig {

    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(){
        RedisTemplate<String,String> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        logger.info("create RedisTemplate success");
        return template;
    }
}
