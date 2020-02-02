package com.example.tesk1.proxy;

import com.example.tesk1.dto.request.TestRequest;
import com.example.tesk1.dto.response.TestResult;
import org.springframework.http.ResponseEntity;

public interface ThirdPartyCallProxy {
    ResponseEntity<TestResult> callSampleThirdParty(TestRequest text);
}
