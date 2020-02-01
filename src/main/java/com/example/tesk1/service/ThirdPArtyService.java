package com.example.tesk1.service;

import com.example.tesk1.dto.response.TestResult;

public interface ThirdPArtyService {

     TestResult callThirdParty(String htmlText);
}
