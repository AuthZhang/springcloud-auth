package com.zhangyu.thread.bosszhipin;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    @PostConstruct
    public void init() {
    }

    public User(Integer age) {
        this.age = age;
    }

    // 第三题
    public static void remove(List<User> userList){
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            if (next.getAge() > 20){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        User user = new User(1);
        User user1 = new User(20);
        User user2 = new User(21);
        User user3 = new User(15);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        remove(list);
        System.out.println();
    }
}
