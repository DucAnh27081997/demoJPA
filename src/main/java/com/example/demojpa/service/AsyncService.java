package com.example.demojpa.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    public void calculateV1(){
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                System.out.println("calculateV1 = "+i);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Async
    public void calculateV2(){
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                System.out.println("calculateV2 = "+i);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
