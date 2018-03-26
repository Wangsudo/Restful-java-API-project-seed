package com.walker.rediscomsumer.service;

/**
 * Created by wangshun on 2018/3/24
 **/
public interface RedisQueueListener<T> {

    void onMessage(T value);
    
    void startup();
}
