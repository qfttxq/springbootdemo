package com.example.d1;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@Slf4j
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("session 创建了");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("session 销毁了");
    }
}
