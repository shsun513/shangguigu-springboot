package com.minidwep.springboot03logging;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

@SpringBootTest
class Springboot03LoggingApplicationTests {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
//        日志的级别由低到高
//        可以调整需要输出的日志级别

//        logger.info("Start to verify User [{}]",null);
        logger.trace(null);
        logger.debug(null);
        logger.info(null);
        logger.warn(null);
        logger.error(null);
    }

}
