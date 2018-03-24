package com.walker.rediscomsumer.service;

/**
 * Created by wangshun on 2018/3/24
 **/
public interface RedisQueueListener<T> {

    public void onMessage(T value);
}
