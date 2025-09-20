package com.handling.api.multi.multiAPIHandling.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Configuration
@Slf4j
public class RestTemplateConfig {
    @Bean
    RestTemplate createRestTemplateBean(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
