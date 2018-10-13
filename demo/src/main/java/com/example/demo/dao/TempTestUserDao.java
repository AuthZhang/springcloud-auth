package com.example.demo.dao;

import com.example.demo.entity.TempTestUser;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TempTestUserDao extends JpaRepository<TempTestUser,Long> {
}
