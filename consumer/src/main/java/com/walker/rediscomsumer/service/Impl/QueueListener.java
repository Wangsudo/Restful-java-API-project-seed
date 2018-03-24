package com.walker.rediscomsumer.service.Impl;

import com.walker.rediscomsumer.service.RedisQueueListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangshun on 2018/3/24
 **/
public class QueueListener<String> implements RedisQueueListener<String> {

    private Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @Override
    public void onMessage(String value) {
        logger.info("get message={}",value);
    }



}
