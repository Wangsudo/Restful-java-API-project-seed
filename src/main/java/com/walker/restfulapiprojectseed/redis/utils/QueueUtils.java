package com.walker.restfulapiprojectseed.redis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by wangshun on 2018/3/24
 **/
public class QueueUtils {
    private static final Logger log = LoggerFactory.getLogger(QueueUtils.class);
    /**
     * 注解@Resource 是通过名称进行注入，不是spring提供的，而@Autowired是通过类型进行注入
     */
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    private static QueueUtils queueUtils;

    /**
     * 注解@PostConstruct 用于在依赖关系注入完成之后需要执行的方法上，以执行任何初始化。
     * 为什么使用@PostConstruct 进行初始化
     * 就此例来讲，构造函数被调用的时候，bean尚未初始化， 即redisTemplate没有被注入。
     * 在@PostConstruct方法中，bean已经被初始化，redisTemplate已经被注入，可以使用依赖关系。
     */
    @PostConstruct
    public void init(){
        log.info("因为@PostConstruct,init()在构造函数调用之后，会执行此初始化方法");
        queueUtils = this;
        queueUtils.redisTemplate = this.redisTemplate;
    }


    /**
     * 将数据插入队列左边
     * @param key
     * @param val
     */
    public static void sendMessage (String key,String val){
        ListOperations<String,String> listOperations = queueUtils.redisTemplate.opsForList();
        listOperations.leftPush(key,val);
        log.info("将数据插入队列左边");
    }

    /**
     * 从队列右边读取并消除此数据
     * @param key
     * @return
     */
    public static String getMessage (String key){
        log.info("从队列右边读取并消除此数据");
        ListOperations<String,String> listOperations = queueUtils.redisTemplate.opsForList();
        return listOperations.rightPop("queue");
    }

}
