package com.handling.api.multi.multiAPIHandling.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Slf4j
public class CountryConfig {

    @Value("${service.country}")
    private String countryToken;

    @Bean
    RequestInterceptor countryRequestInterceptor() {
        return requestTemplate -> {
            try {
                String encodedToken = URLEncoder.encode(countryToken,"UTF-8");
                requestTemplate.query("accessToken",encodedToken);
                requestTemplate.query("statYm","202105");
            } catch (UnsupportedEncodingException e) {
                log.info("Country API Key encoding error", e);
            }
        };
    }
}
