package com.example.d1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("demo")
@Slf4j
public class DemoController {
    @RequestMapping("hello")
    @Log("对世界说了一句你好")
    public String sayHello() throws Exception {
        //log.info("aabbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        //throw new Exception("abc");
        return "hello ,world";
    }
    @RequestMapping("check")
    public String check(HttpServletRequest request){
        String id = request.getSession().getId();
        String name = (String) request.getSession().getAttribute("name");
        if(StringUtils.isEmpty(name)){
            request.getSession().setAttribute("name","zhangsan");
        }
        log.info("id:{},name:{}",id,name);
        return String.format("sessionId:%s,name:%s",id,name);
    }
}
