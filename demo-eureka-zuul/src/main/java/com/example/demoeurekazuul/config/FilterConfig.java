package com.example.demoeurekazuul.config;

import com.example.demoeurekazuul.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public MyPreFilter mypreFilter() {
        return new MyPreFilter();
    }
    @Bean
    public MyPreFilter2 mypreFilter2() {
        return new MyPreFilter2();
    }

    @Bean
    public MyRoutingFilter myroutingFilter() {
        return new MyRoutingFilter();
    }
    @Bean
    public MyRoutingFilter2 myroutingFilter2() {
        return new MyRoutingFilter2();
    }
    @Bean
    public MyErrorFilter myerrorFilter() {
        return new MyErrorFilter();
    }
    @Bean
    public MyPostFilter mypostFilter() {
        return new MyPostFilter();
    }
}
