package com.handling.api.multi.multiAPIHandling.controller;

import com.handling.api.multi.multiAPIHandling.openFeignInterface.OpenFeignStorage;
import com.handling.api.multi.multiAPIHandling.service.OpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/openfeign")
public class OpenFeignRestController {

    final private OpenFeignService openFeignService;

    @Autowired
    public OpenFeignRestController(OpenFeignService openFeignService){
        this.openFeignService = openFeignService;
    }

    @GetMapping
    public ResponseEntity<String> rootPage(){
        return ResponseEntity.status(HttpStatus.OK).body("OpenFeign root");
    }
    @GetMapping("/1")
    public ResponseEntity<String> openFeignGNA(){
        return ResponseEntity.status(HttpStatus.OK).
                body(openFeignService.getAllInfoOfGAN());
    }

    @GetMapping("/2")
    public ResponseEntity<String> openFeignCountry(){
        return ResponseEntity.status(HttpStatus.OK).
                body(openFeignService.getAllInfoOfCountry());
    }

    @GetMapping("/3")
    public ResponseEntity<String> openFeignStorage(){
        return ResponseEntity.status(HttpStatus.OK).
                body(openFeignService.getAllInfoOfStorage());
    }
}
