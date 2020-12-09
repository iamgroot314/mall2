package com.sk.mall2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.sk.mall2.dao")
@EnableTransactionManagement
public class Mall2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mall2Application.class, args);
    }

}
