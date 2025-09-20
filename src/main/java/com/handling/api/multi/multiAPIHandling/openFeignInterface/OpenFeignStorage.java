package com.handling.api.multi.multiAPIHandling.openFeignInterface;

import com.handling.api.multi.multiAPIHandling.config.StorageConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient는 Spring이 해당 인터페이스의 구현체를 Bean으로 만들어 등록하도록 지시하는 어노테이션
@FeignClient(
        name = "storage-api",
        url = "https://api.incheoneasy.com/api/tour/packStorageList",
        configuration = StorageConfig.class
)
public interface OpenFeignStorage {
    @GetMapping
    String storageService();
}
