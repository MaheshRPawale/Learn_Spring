package com.inventory.management.system.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
    @Bean
  public   ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
