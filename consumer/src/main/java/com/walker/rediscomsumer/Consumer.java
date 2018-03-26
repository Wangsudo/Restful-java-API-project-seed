package com.walker.rediscomsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wangshun on 2018/3/24
 **/
@SpringBootApplication
public class Consumer {
    private static final Logger Logger = LoggerFactory.getLogger(Consumer.class);
    
    public static void main(String[] args){
        SpringApplication.run(Consumer.class);
    }
    
    @Bean
    CommandLineRunner startServer(){
        return args->{
            logger.info("start);
            Iservice.startUp();
        }
    }
}
