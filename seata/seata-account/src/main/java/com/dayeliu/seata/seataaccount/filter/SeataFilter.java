package com.dayeliu.seata.seataaccount.filter;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liuch
 * @date 2020/10/10 - 23:10
 */
@Component
@Slf4j
public class SeataFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String xid = request.getHeader(RootContext.KEY_XID.toLowerCase());
        boolean isBind = false;
        if (!StringUtils.isEmpty(xid)) {
            RootContext.bind(xid);
            log.info("SeataFilter xid {}",RootContext.getXID());
            isBind = true;
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            if (isBind) {
                RootContext.unbind();
                log.info("SeataFilter xid {}",RootContext.getXID());
            }
        }



    }

    @Override
    public void destroy() {

    }
}
