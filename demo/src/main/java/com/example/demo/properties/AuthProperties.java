package com.example.demo.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author zhangyu
 * @Date 2018/9/28
 */
public class AuthProperties {

    @Value("${com.auth.title}")
    private String title;
}
