package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangyu
 * @Date 2018/9/27
 */
@RestController()
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        return "hello boot";
    }

    @RequestMapping(value = "/getUser")
    public User getUser(){
        User user=new User();
        user.setName("小明");
        user.setPassword("小明的密码");
        return user;

    }
}
