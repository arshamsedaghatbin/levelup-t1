package com.example.tesk1;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Tesk1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tesk1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
