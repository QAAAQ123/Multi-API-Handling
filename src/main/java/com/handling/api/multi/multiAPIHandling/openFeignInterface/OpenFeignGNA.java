package com.handling.api.multi.multiAPIHandling.openFeignInterface;

import com.handling.api.multi.multiAPIHandling.config.GNAConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "gna-api",
        url = "https://api.incheoneasy.com/api/tour/visitorList",
        configuration = GNAConfig.class
)
public interface OpenFeignGNA {
    @GetMapping
    String gnaService();
}
