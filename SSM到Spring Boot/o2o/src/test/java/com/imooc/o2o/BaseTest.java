package com.imooc.o2o;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件的位置
// 需要用到配置文件中所扫描的Bean，如果不声明配置，会导致注入失败
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml", "classpath:spring/spring-redis.xml"
})
public class BaseTest {
    // 此方法为空，不写会报No runnable methods ERROR
    @Test
    public void test(){
        System.out.println(System.getProperty("java.version"));
    }
}