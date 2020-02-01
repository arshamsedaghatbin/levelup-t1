package com.example.tesk1;

import com.example.tesk1.dto.response.TestResult;
import com.example.tesk1.service.ThirdPArtyService;
import com.example.tesk1.service.impl.ThirdPartyServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class Tesk1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tesk1Application.class, args);
	}

	@Autowired
	private ThirdPArtyService thirdPArtyService;
	@Override
	public void run(String... args)  {
		TestResult testResult = thirdPArtyService.callThirdParty(args[0]);
		System.out.println(testResult.toString());
	}

	@Bean
	public RestTemplate restTemplate(MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		return restTemplate;
	}

	@Bean
	public ClientHttpRequestFactory getClientFactory(){
		return new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public MappingJackson2HttpMessageConverter messageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(getObjectMapper());
		return converter;
	}
}
