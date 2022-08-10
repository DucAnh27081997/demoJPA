package com.example.demojpa.service;

import com.example.demojpa.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public void addAll(int x);
    public void addAll2(int x);
}
