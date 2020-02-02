 package com.example.tesk1.service.impl;

import com.example.tesk1.dto.request.TestRequest;
import com.example.tesk1.dto.response.TestResult;
import com.example.tesk1.exceptions.ThirdPartyServiceException;
import com.example.tesk1.proxy.ThirdPartyCallProxy;
import com.example.tesk1.proxy.impl.ThirdPartyCallProxyImpl;
import com.example.tesk1.service.ThirdPArtyService;
import com.example.tesk1.util.SanitizerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

 @Service
public class ThirdPartyServiceImpl implements ThirdPArtyService {


    @Autowired
    private ThirdPartyCallProxy thirdPartyCallProxy;

    public TestResult callThirdParty(String htmlText){
        String textResult = SanitizerUtil.removeHtmTag(htmlText);
        textResult=SanitizerUtil.validateForbiddenChar(textResult);
        TestRequest testRequest=new TestRequest();
        testRequest.setText(textResult);
        ResponseEntity<TestResult> result = thirdPartyCallProxy.callSampleThirdParty(testRequest);
        if (!result.getStatusCode().is2xxSuccessful()){
            throw new ThirdPartyServiceException("third party exception",result.getStatusCode().value());
        }
        else return result.getBody();
    }

}
