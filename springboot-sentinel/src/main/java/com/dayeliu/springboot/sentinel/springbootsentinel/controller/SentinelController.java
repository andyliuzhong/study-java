package com.dayeliu.springboot.sentinel.springbootsentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuch
 * @date 2020/10/4 - 22:58
 */
@RestController
public class SentinelController {
    @GetMapping("/test")
    @SentinelResource(value = "test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/test1")
    @SentinelResource(value = "test1",fallback = "fallback",blockHandler = "exceptionH")
    public String test1(){
        int i = 1/0;//模拟异常 -> fallback  限流 ->exceptionH
        return "ok1";
    }

    public String exceptionH(BlockException ex){
        ex.printStackTrace();  //限流
        return "exceptionH";

    }
    public String fallback(){
        System.out.println("fallback");  //降级
        return "fallback";
    }
}
