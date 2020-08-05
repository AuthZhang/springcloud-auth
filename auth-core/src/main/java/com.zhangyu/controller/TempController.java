package com.zhangyu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@RequestMapping(value = "/temp")
public class TempController {

    @GetMapping("/get")
    public String  get(){
        return "a";
    }

    public static void main(String[] args) {

    }
}
