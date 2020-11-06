package com.dayeliu.seata.seataaccount.interceptor;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author liuch
 * @date 2020/10/10 - 22:56
 */
@Slf4j
public class SeataRestTemplateInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper(httpRequest);
        String xid = RootContext.getXID();
        log.info("SeataRestTemplateInterceptor xid " + xid);
        if (!StringUtils.isEmpty(xid)) {
            httpRequestWrapper.getHeaders().add(RootContext.KEY_XID, xid);
        }
        return clientHttpRequestExecution.execute(httpRequestWrapper, bytes);
    }


}
