package com.example.d2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @RequestMapping("index")
    public String index(){
        return "这里是首页";
    }
    @RequestMapping("admin")
    public String admin(){
        return "这里是管理页面";
    }
}
