package com.walker.restfulapiprojectseed;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulApiProjectSeedApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //测试redis配置是否成功
    @Test
	public void test() {
        stringRedisTemplate.opsForValue().set("name","jichun");
        Assert.assertEquals("jichun",stringRedisTemplate.opsForValue().get("name"));
	}

}
