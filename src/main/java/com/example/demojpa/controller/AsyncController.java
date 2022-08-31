package com.example.demojpa.controller;

import com.example.demojpa.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.Sss");

    @RequestMapping(value = "/no-async")
    public String calculateV1(){
        Long startTime=System.currentTimeMillis();
        asyncService.calculateV1();
        return simpleDateFormat.format(new Date())+"<=>"+(System.currentTimeMillis()-startTime)/1000;
    }

    @RequestMapping(value = "/async")
    public String calculateV2(){
        Long startTime=System.currentTimeMillis();
        asyncService.calculateV2();
        return simpleDateFormat.format(new Date())+"<=>"+(System.currentTimeMillis()-startTime)/1000;
    }
}
