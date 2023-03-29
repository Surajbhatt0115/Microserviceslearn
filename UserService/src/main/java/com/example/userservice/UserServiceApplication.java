package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.userservice.Vo.ResponseTemplateVo;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class })
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}		
	
	@Bean
	@LoadBalanced // to load balance or manage differnet service 
	public  RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
