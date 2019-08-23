package com.example.d1;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Slf4j
public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        boolean isNew = request.getSession().isNew();
        String url = request.getServletPath();
        log.info(url);
        if(isNew && !"/demo/check".equals(url)){
            servletResponse.setContentType("text/json;charset=utf-8");//须通过这种方式设置字符集，直接设置无用
            servletResponse.getWriter().print("session超时了");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
