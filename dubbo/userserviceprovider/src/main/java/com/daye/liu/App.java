package com.daye.liu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 1.服务提供者启动 注册到注册中心
 * 1).导入dubbo依赖(2.6.2)
 * 2.配置服务提供者
 * Hello world!
 */
public class App {
    private static final Logger LOGGER =LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("provider.xml");
        classPathXmlApplicationContext.start();
        System.in.read();
    }
}
