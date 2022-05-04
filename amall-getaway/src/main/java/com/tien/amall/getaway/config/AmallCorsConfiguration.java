package com.tien.amall.getaway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

// 解决跨域问题的配置类
@Configuration // 标注这是一个配置类
public class AmallCorsConfiguration {

    @Bean // 加入到容器中
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 1、配置跨域
        corsConfiguration.addAllowedHeader("*"); // 允许哪些头跨域
        corsConfiguration.addAllowedMethod("*"); // 允许哪些方法跨域
        corsConfiguration.addAllowedOriginPattern("*"); // 允许哪些请求来源跨域
        corsConfiguration.setAllowCredentials(true); // 允许携带 cookie 跨域
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
