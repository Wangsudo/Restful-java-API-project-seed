package com.walker.restfulapiprojectseed.redis.config;

import com.walker.restfulapiprojectseed.redis.utils.QueueUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 注册配置类到容器
 * Created by wangshun on 2018/3/24
 **/
@Configuration
@Import({RedisConfig.class, QueueUtils.class})
public class RedisAutoConfiguration {
}
