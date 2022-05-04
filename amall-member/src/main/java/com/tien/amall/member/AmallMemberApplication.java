package com.tien.amall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.tien.amall.member.feign")
@EnableDiscoveryClient
@MapperScan("com.tien.amall.member.dao")
@SpringBootApplication
public class AmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmallMemberApplication.class, args);
    }

}
