package com.walker.rediscomsumer;

import com.walker.rediscomsumer.service.RedisQueueListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by wangshun on 2018/3/24
 **/
@SpringBootApplication
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    
    @Autowired
    private RedisQueueListener queueListener;
    
    public static void main(String[] args){
        SpringApplication.run(Consumer.class);
    }
    
    @Bean
    CommandLineRunner startServer(){
        return args->{
            logger.info("start");
            queueListener.startup();
        };
    }
}
