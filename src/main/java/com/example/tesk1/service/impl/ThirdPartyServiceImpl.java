 package com.example.tesk1.service.impl;

import com.example.tesk1.exceptions.ThirdPartyServiceException;
import com.example.tesk1.proxy.ThirdPartyCallProxy;
import com.example.tesk1.service.ThirdPArtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyServiceImpl implements ThirdPArtyService {


    @Autowired
    private ThirdPartyCallProxy thirdPartyCallProxy;
    public void callThirdParty(String htmlText){
        ResponseEntity<Void> result = thirdPartyCallProxy.thirdPartyCall(htmlText);
        if (!result.getStatusCode().is2xxSuccessful()){
            throw new ThirdPartyServiceException("third party exception",result.getStatusCode().value());
        }
    }

}
