package com.tien.amall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.tien.amall.product.feign")
@EnableDiscoveryClient
@MapperScan("com.tien.amall.product.dao")
@SpringBootApplication
public class AmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmallProductApplication.class, args);
    }

}
