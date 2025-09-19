package com.handling.api.multi.multiAPIHandling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class RestTamplateService {

    private final RestTemplate restTemplate;

    //성별과 연령대별 방문객 정보 조회
    @Value("${service.gender.and.age}")
    private String vistorsGenderAgeToken;//인코딩전

    @Value("${service.country}")
    private String countryToken;

    @Value("${service.storage}")
    private String storageToken;

    @Autowired
    public RestTamplateService(RestTemplate restTemplate) throws UnsupportedEncodingException {
        this.restTemplate = restTemplate;
    }

    public String getAllInfoOfGenderAndAgeAPI() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        String yearAndMonth = now.format(formatter);


        String vistorsGenderAgeEncodedToken = null;
        try {
            vistorsGenderAgeEncodedToken = URLEncoder.encode(vistorsGenderAgeToken, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.info("Gender and Age API Key error");
            return null;
        }

        //API Request URL example: 형식	https://api.incheoneasy.com/api/ture/nationVisitorList?accessToken=토큰값&statYm=202101
        //가장 최신 연월이 안되서 임시 값임 21년 5월로 고정함
        final String requestURL = "https://api.incheoneasy.com/api/tour/visitorList?accessToken=" + vistorsGenderAgeEncodedToken + "&statYm=" + "202105";

        ResponseEntity<String> genderAndAgeResponse =
                restTemplate.exchange(requestURL, HttpMethod.GET, null, String.class);

        return genderAndAgeResponse.getBody();
    }


    public String getAllInfoOfCountryAPI() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        String yearAndMonth = now.format(formatter);


        String countryEncodedToken = null;
        try {
            countryEncodedToken = URLEncoder.encode(countryToken, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.info("country API Key error");
            return null;
        }

        //API Request URL example: https://api.incheoneasy.com/api/ture/nationVisitorList?accessToken=토큰값&statYm=202101
        //가장 최신 연월이 안되서 임시 값임 21년 5월로 고정함
        final String requestURL = "https://api.incheoneasy.com/api/tour/nationVisitorList?accessToken=" + countryEncodedToken + "&statYm=" + "202105";

        ResponseEntity<String> countryResponse =
                restTemplate.exchange(requestURL, HttpMethod.GET, null, String.class);

        return countryResponse.getBody();
    }

    public String getAllInfoOfStorageAPI() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        String yearAndMonth = now.format(formatter);


        String storageEncodedToken = null;
        try {
            storageEncodedToken = URLEncoder.encode(storageToken, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.info("storage API Key error");
            return null;
        }

        //API Request URL example: https://api.incheoneasy.com/api/tour/packStorageList?accessToken=토큰값
        final String requestURL = "https://api.incheoneasy.com/api/tour/packStorageList?accessToken=" + storageEncodedToken;

        ResponseEntity<String> storageResponse =
                restTemplate.exchange(requestURL, HttpMethod.GET, null, String.class);

        return storageResponse.getBody();
    }
}
