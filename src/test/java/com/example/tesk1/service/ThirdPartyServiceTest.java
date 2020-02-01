package com.example.tesk1.service;

import com.example.tesk1.dto.response.TestResult;
import com.example.tesk1.exceptions.ThirdPartyServiceException;
import com.example.tesk1.proxy.ThirdPartyCallProxy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ThirdPartyServiceTest extends TestData {


	@MockBean
	private ThirdPartyCallProxy thirdPartyCallProxy;


	@Autowired
	private ThirdPArtyService thirdPArtyService;



	@Test
	void check_accept_third_party() {
		ResponseEntity<TestResult> responseEntity = new ResponseEntity<TestResult>(HttpStatus.ACCEPTED);
		Mockito.when(thirdPartyCallProxy.callSampleThirdParty(any())
		).thenReturn(responseEntity);
		thirdPArtyService.callThirdParty(strHTML);
	}


	@Test
	void check_exception_third_party() {
		ResponseEntity<TestResult> responseEntity = new ResponseEntity<TestResult>(HttpStatus.BAD_REQUEST);
		Mockito.when(thirdPartyCallProxy.callSampleThirdParty(any())
		).thenReturn(responseEntity);
		assertThrows(ThirdPartyServiceException.class, () -> {
			thirdPArtyService.callThirdParty(strHTML);
		});
	}

}
