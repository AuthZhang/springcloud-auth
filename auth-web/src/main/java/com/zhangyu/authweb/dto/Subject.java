package com.zhangyu.authweb.dto;



public class Subject {

    private String name = "auth";

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
