package com.walker.restfulapiprojectseed.aop;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Created by wangshun on 2018/3/18
 **/
@Aspect
@Component
@Order(1)    //标记切面类的处理优先级，数值越小，优先级别越高，PS：可以注解类，也可以注解到方法上
public class LogAspect {

    private Logger log = Logger.getLogger(String.valueOf(getClass()));
    private Gson gson = new Gson();

    /**
     * 计算相应时间,定义一个成员变量,用来统计时间,同时给@Before跟@AfterReturning访问,
     * 可能会有同步的问题,所以我们引用一个ThreadLocal<Long>指定泛型的对象,
     * 在@Before记录请求的时间,在@AfterReturning扣除记录的时间,就是消耗的时间
     **/
    private ThreadLocal<Long> startTime = new ThreadLocal<>();


    /**
     * 注解@Pointcut说明：
     * 定义一个方法，使其为切点,里面的内容为一个表达式，表达式指定一个路径，每个切点只能处理指定路径
     *
     * execution表达式
     *  第一个 public 表示方法的修饰符,可以用*代替
     *  第一个 * 表示 返回值,*代表所有
     *  com.walker.restfulapiprojectseed.controller.DomeController 类路径,.*表示该类下的所有方法
     *  com.walker.restfulapiprojectseed.*.*.*(..)  第一个.* 表示该路径下所有包，第二个.* 表示该路径下所有包下的所有类,第二个.*表示所有类的方法
     *  (..) 表示不限方法参数
     */
    //声明一个方法， 切点里面是的内容是execution表达式
    @Pointcut(value = "execution(public * com.walker.restfulapiprojectseed.controller.*.*(..))")
    private void controllerAspect(){}


    /**
     * 注解说明：
     * 1。@Before 在切点前执行方法,内容为指定的切点
     * 2。@After 在切点后，return前执行
     * 3。注解@AfterReturning  在切入点return后执行如果想对某些方法的返回参数进行处理。
     * 4。@Around 环绕切点,在进入切点前,跟切点后执行
     * 5。@AfterThrowing 在切点后抛出异常进行处理
     * 6。@order(i) 标记切点的优先级,i越小,优先级越高
     *      注解的是 @Before 是i值越小,优先级越高
     *      注解的是 @After或者@AfterReturning 中,i值越大,优先级越高
     */
    //请求method前打印内容，，，在切点前执行方法，内容为指定的切点
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        //获取请求时间
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        StringBuffer url = request.getRequestURL();
        if (!StringUtils.isEmpty(request.getQueryString())){
            url.append("?").append(request.getQueryString());
        }
        //打印请求内容
        log.info("==============请求内容==============");
        log.info("url："+ url);
        log.info("请求方式："+request.getMethod());
        log.info("请求类方法："+joinPoint.getSignature());
        log.info("请求类方法参数："+ gson.toJson(joinPoint.getArgs()));
        log.info(joinPoint.getKind());
        log.info(joinPoint.getSourceLocation()+"");
        log.info(joinPoint.getTarget()+"");

    }



    //在方法执行完打印返回值
    @AfterReturning(returning = "o",pointcut = "controllerAspect()")
    public void methedAfterRturning(Object o){
        log.info("==============响应内容==============");
        log.info("Response:"+gson.toJson(o));
        log.info("Response time:"+(System.currentTimeMillis()-startTime.get())+"ms");
    }

}
