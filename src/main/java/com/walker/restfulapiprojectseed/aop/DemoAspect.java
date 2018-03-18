package com.walker.restfulapiprojectseed.aop;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by wangshun on 2018/3/18
 **/
@Aspect
@Component
@Order(1)    //标记切面类的处理优先级，优先级别越高，PS：可以注解类，也可以注解到方法上
public class DemoAspect {

    private Logger log = Logger.getLogger(String.valueOf(getClass()));
    private Gson gson = new Gson();

    /**
     * 计算相应时间,定义一个成员变量,用来统计时间,同时给@Before跟@AfterReturning访问,
     * 可能会有同步的问题,所以我们引用一个ThreadLocal<Long>指定泛型的对象,
     * 在@Before记录请求的时间,在@AfterReturning扣除记录的时间,就是消耗的时间
     **/
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    //声明一个切点   里面是execution表达式
    @Pointcut(value = "execution(public * com.walker.restfulapiprojectseed.controller.DomeController.*(..))")
    private void controllerAspect(){}

    //请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        //获取请求时间
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();

        //打印请求内容
        log.info("==============request==============");
        log.info("请求地址："+ request.getRequestURI());
        log.info("请求方式："+request.getMethod());
        log.info("请求类方法："+joinPoint.getSignature());
        log.info("请求类方法参数："+ Arrays.toString(joinPoint.getArgs()));
        log.info("==============request==============");
    }

    //在方法执行完打印返回值
    @AfterReturning(returning = "o",pointcut = "controllerAspect()")
    public void methedAfterRturning(Object o){
        log.info("==============response==============");
        log.info("Response:"+gson.toJson(o));
        log.info("==============response==============");
        log.info("请求响应时间:"+(System.currentTimeMillis()-startTime.get())+"ms");
    }

}
