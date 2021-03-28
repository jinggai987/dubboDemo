package com.dubbo.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * springboot与dubbo整合三种方式
 * 1.导入dubbo-starter,在application.properties中配置属性，使用dubbo包下的@service暴露服务，用@reference引用服务
 * 2.保留provider.xml配置，导入dubbo-starter，使用@ImportResource(locations = "classpath:provider.xml")导入dubbo配置文件
 * 3.使用注解api,将每一个组件手动创建到容器中,让dubbo来扫描其他的组件
 */
//@EnableDubbo
//@ImportResource(locations = "classpath:provider.xml")
 @EnableDubbo(scanBasePackages = "com.dubbo")
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
