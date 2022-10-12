package com.area.demo;

import com.area.demo.controller.AreaCodeController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.area.demo.dao")
public class DemoApplication implements CommandLineRunner {

    @Autowired
    AreaCodeController areaCodeController;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        areaCodeController.getAreaCode();
    }
}
