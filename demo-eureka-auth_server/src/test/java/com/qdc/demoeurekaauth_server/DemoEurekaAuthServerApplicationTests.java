package com.qdc.demoeurekaauth_server;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoEurekaAuthServerApplicationTests {

    @Autowired
     private DruidDataSource druidDataSource;


    @Test
    void contextLoads() {
        System.out.println(druidDataSource);
    }


    @Test
    void testuserpassword(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
