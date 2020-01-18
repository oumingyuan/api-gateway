package com.example.apigateway.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class GlobalCorsConfig {


    /**
     * options 问题解决
     *
     * @return 返回
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        // 重写父类提供的跨域请求处理的接口
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 添加映射路径
                registry.addMapping("/**")
                        // 放行哪些原始域
                        .allowedOrigins("*")
                        // 放行哪些请求方式
                        .allowedMethods("*")
                        // 是否允许携带 cookie
                        .allowCredentials(true)
                        // 放行哪些头部信息
                        .allowedHeaders("*");
            }
        };
    }
}

