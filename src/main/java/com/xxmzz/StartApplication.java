package com.xxmzz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author CHEN-PJ
 * @title: StartApplication
 * @projectName mall
 * @description: TODO
 * @date 2022/2/710:54
 */
@SpringBootApplication
@MapperScan("com.xxmzz.mapper")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}