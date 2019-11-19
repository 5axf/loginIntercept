package com.loginIntercept.loginIntercept.controller;

import com.loginIntercept.loginIntercept.annotation.LoginRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class test {
    static final Logger log = LoggerFactory.getLogger(test.class);

    @RequestMapping("/index")
    public void test(){
        log.info("进入了首页");
    }

    @RequestMapping("/login")
    @LoginRequired
    public void test2(String login){
        log.info("进入了登录方法,参数login："+login);
    }
}
