package com.example.demojpa;

import com.example.demojpa.util.HashUtil;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

//@SpringBootTest
class DemoJpaApplicationTests {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("AfterAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }

    @Test
    void checkSoChan() {
        int n = 10;
        boolean expected = true;
        boolean actual = HashUtil.checkChan(n);
        System.out.println("actual checkSoChan= " + actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkSoLe() {
        int n = 3;
        boolean expected = false;
        boolean actual = HashUtil.checkChan(n);
        System.out.println("actual checkSoLe = " + actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void hashNumber() throws NoSuchAlgorithmException {
        String plainText = "admin";
        String expected = "21232f297a57a5a743894a0e4a801fc3";
        String actual = HashUtil.hash(plainText).toLowerCase();
        System.out.println("actual hashText = " + actual);
        Assertions.assertEquals(expected, actual);
    }

}
