package com.fanyfahmi.idraggregator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class StorageConfig {
    @Bean
    public Map<String, Object> internalStorage() {
        return new ConcurrentHashMap<>();
    }
}
