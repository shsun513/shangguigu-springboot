package com.minidwep.springboot;

import com.minidwep.springboot.bean.Person;
import com.minidwep.springboot.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * 这是SpringBoot的单元测试；
 *
 * 可以在测试期间很方便的 类似编码一样进行自动注入容器的功能
 */
@SpringBootTest
class Springboot02ConfigApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
        System.out.println(person.getDog().toString());
    }

    @Test
    public void testHelloService(){
        boolean helloService =  ioc.containsBean("helloService");
        System.out.println(helloService);
    }

}
