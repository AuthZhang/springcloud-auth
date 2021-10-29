package com.zhangyu.authweb.dto;



public class User {

    private String name = "auth";

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
