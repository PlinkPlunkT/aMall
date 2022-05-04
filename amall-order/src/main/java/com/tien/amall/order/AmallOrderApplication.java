package com.tien.amall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.tien.amall.order.dao")
@SpringBootApplication
public class AmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmallOrderApplication.class, args);
    }

}
