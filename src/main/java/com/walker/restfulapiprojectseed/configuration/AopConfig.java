package com.walker.restfulapiprojectseed.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by wangshun on 2018/3/18
 **/
@Configuration
@ComponentScan("com.walker")
@EnableAspectJAutoProxy
public class AopConfig {

}
