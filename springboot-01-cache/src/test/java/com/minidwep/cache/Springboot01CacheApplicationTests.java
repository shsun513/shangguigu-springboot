package com.minidwep.cache;

import com.minidwep.cache.bean.Employee;
import com.minidwep.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Springboot01CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     *  String （字符串） List（列表） Set（集合） Hash（散列） ZSet(有序集合)
     *  stringRedisTemplate.opsForValue()[String 字符串]
     *  stringRedisTemplate.opsForList（）[List 列表]
     *  stringRedisTemplate.opsForSet()[Set 集合]
     *  stringRedisTemplate.opsForHash()[Hash 散列]
     *  stringRedisTemplate.opsForZSet()[ZSet 有序集合]
     */

    @Test
    void test1(){
        //给Redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("mylist","a");
        stringRedisTemplate.opsForList().leftPush("mylist","b");
        stringRedisTemplate.opsForList().leftPush("mylist","c");

    }

    @Test
    public void test02(){
        Employee emp = employeeMapper.getEmp(1);
//        默认保存数据，使用jdk序列化机制。序列化后的数据保存到redis中
        redisTemplate.opsForValue().set("emp-01",emp);
//       1.将数据以json保存
//        (1)自己将对象转为json
//        (2)redisTemplate默认的序列化规则
    }

    @Test
    void contextLoads() {
        Employee emp = employeeMapper.getEmp(1);
        System.out.println(emp);

    }

}
