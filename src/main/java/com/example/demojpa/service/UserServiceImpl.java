package com.example.demojpa.service;

import com.example.demojpa.entity.AuthorStatus;
import com.example.demojpa.entity.User;
import com.example.demojpa.repository.UserRepositoy;
import com.example.demojpa.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoy userRepositoy;

    @Override
    public List<User> findAll() {
        return userRepositoy.findAll();
    }

    @Override
    public void addAll(int x) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyy_HHmmss.SSS");
            Long timeStart = System.currentTimeMillis();
            for (int i = 0; i < x; i++) {
                String date = simpleDateFormat.format(new Date());
                User u = User.builder()
                        .name("ducla_" + i + "_" + date)
                        .status(AuthorStatus.NOT_PUBLISHED)
                        .hashCode(HashUtil.hash("ducla_"+i+"_"+date))
                        .build();
                userRepositoy.save(u);
            }
            System.out.println("total time run: " + (System.currentTimeMillis() - timeStart) / 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addAll2(int x) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyy_HHmmss.SSS");
            Long timeStart = System.currentTimeMillis();
            List<User> lst = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                String date = simpleDateFormat.format(new Date());
                User u = User.builder()
                        .name("ducla_" + i + "_" + date)
                        .status(AuthorStatus.NOT_PUBLISHED)
                        .hashCode(HashUtil.hash("ducla_"+i+"_"+date))
                        .build();
                lst.add(u);
            }
            userRepositoy.saveAll(lst);
            System.out.println("total time run: " + (System.currentTimeMillis() - timeStart) / 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //sua mot chut
}
