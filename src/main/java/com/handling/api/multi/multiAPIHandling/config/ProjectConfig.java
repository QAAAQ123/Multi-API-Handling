package com.handling.api.multi.multiAPIHandling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProjectConfig {
    @Bean
    RestTemplate createRestTemplateBean(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
