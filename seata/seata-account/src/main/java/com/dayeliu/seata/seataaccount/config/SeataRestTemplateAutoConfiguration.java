package com.dayeliu.seata.seataaccount.config;

import com.dayeliu.seata.seataaccount.interceptor.SeataRestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author liuch
 * @date 2020/10/10 - 22:53
 */
@Configuration
public class SeataRestTemplateAutoConfiguration {
    @Autowired(required = false)
    private Collection<RestTemplate> restTemplates;

    @Autowired
    private SeataRestTemplateInterceptor seataRestTemplateInterceptor;

    public SeataRestTemplateAutoConfiguration() {

    }

    @Bean
    public SeataRestTemplateInterceptor seataRestTemplateInterceptor(){
        return new SeataRestTemplateInterceptor();
    }
    @PostConstruct
    public void init(){
        if (this.restTemplates != null) {
            System.out.println(restTemplates + "======================");
            Iterator<RestTemplate> iterator = this.restTemplates.iterator();
            while (iterator.hasNext()) {
                RestTemplate restTemplate = iterator.next();
                List<ClientHttpRequestInterceptor> list = new ArrayList<>(restTemplate.getInterceptors());
                list.add(this.seataRestTemplateInterceptor);
                restTemplate.setInterceptors(list);
            }
        }
    }

}
