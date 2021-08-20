package com.lyr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(RunApplication.class,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
