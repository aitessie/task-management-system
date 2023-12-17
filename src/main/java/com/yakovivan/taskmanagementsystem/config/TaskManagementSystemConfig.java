package com.yakovivan.taskmanagementsystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskManagementSystemConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
