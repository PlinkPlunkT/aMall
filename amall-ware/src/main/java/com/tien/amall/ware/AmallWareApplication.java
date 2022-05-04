package com.tien.amall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.tien.amall.ware.dao")
@SpringBootApplication
public class AmallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmallWareApplication.class, args);
    }

}
