package com.handling.api.multi.multiAPIHandling.openFeignInterface;

import com.handling.api.multi.multiAPIHandling.config.CountryConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "country-api",
        url = "https://api.incheoneasy.com/api/tour/nationVisitorList",
        configuration = CountryConfig.class
)
public interface OpenFeignCountry {
    @GetMapping
    String countryService();
}
