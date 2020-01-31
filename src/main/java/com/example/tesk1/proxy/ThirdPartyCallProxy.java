package com.example.tesk1.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyCallProxy {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${third-party-url}")
    private String thirdPartyUrl;
    public ResponseEntity<Void> thirdPartyCall(String text){

        HttpEntity<String> request = new HttpEntity<>(text);
        return restTemplate.exchange(thirdPartyUrl, HttpMethod.POST, request, Void.class);

    }
}
