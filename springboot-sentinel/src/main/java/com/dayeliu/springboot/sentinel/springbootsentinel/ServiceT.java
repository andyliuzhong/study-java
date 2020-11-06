package com.dayeliu.springboot.sentinel.springbootsentinel;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author liuch
 * @date 2020/11/6 - 22:09
 */
@Service
@Lazy
public class ServiceT {
    public ServiceT() {
        System.err.println("=================lazy");
    }
}
