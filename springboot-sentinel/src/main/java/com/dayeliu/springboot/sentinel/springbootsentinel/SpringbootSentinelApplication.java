package com.dayeliu.springboot.sentinel.springbootsentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootSentinelApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootSentinelApplication.class, args);



                for(String name:context.getBeanDefinitionNames() ){

                    System.out.print(name.equals("serviceT")?name:"");
                }
    }

}
