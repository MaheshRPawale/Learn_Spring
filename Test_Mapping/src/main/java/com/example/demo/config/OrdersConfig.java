package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
@Configuration
public class OrdersConfig {
    @Bean
    @Primary
    public ModelMapper orderModelMapper() {  // Unique name
        return new ModelMapper();
    }
}