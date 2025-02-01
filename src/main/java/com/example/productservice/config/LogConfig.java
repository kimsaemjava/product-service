package com.example.productservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    @Bean
    public Logger.Level getLoggerLevel() {
        return Logger.Level.FULL;
    }
}
