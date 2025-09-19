package com.handling.api.multi.multiAPIHandling.controller;


import com.handling.api.multi.multiAPIHandling.service.RestTamplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class MainController {

    private final RestTamplateService restTamplateService;

    @Autowired
    public MainController(RestTamplateService restTamplateService){
        this.restTamplateService = restTamplateService;
    }

    @GetMapping
    public ResponseEntity<String> rootPage(){
        return ResponseEntity.status(HttpStatus.OK).body("루트");
    }

    @GetMapping("/resttemplate/1")
    public ResponseEntity<String> restTemplateGNA(){
        log.info("Gender and age GET Request");
        return ResponseEntity.status(HttpStatus.OK).
                body(restTamplateService.getAllInfoOfGenderAndAgeAPI());
    }

    @GetMapping("/resttemplate/2")
    public ResponseEntity<String> restTemplateCountry(){
        log.info("Country GET Request");
        return ResponseEntity.status(HttpStatus.OK).
                body(restTamplateService.getAllInfoOfCountryAPI());
    }

    @GetMapping("/resttemplate/3")
    public ResponseEntity<String> restTemplateStorage(){
        log.info("Storage GET Request");
        return ResponseEntity.status(HttpStatus.OK).
                body(restTamplateService.getAllInfoOfStorageAPI());
    }
}
