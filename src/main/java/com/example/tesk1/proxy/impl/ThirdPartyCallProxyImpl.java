package com.example.tesk1.proxy.impl;

import com.example.tesk1.dto.request.TestRequest;
import com.example.tesk1.dto.response.TestResult;
import com.example.tesk1.proxy.ThirdPartyCallProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ThirdPartyCallProxyImpl implements ThirdPartyCallProxy {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${third-party-url}")
    private String thirdPartyUrl;
    @Override
    public ResponseEntity<TestResult> callSampleThirdParty(TestRequest text){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestRequest> request = new HttpEntity<TestRequest>(text,headers);
        return restTemplate.postForEntity(thirdPartyUrl, request, TestResult.class);
    }
}
