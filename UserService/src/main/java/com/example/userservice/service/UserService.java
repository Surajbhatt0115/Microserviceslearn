package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userservice.Vo.Department;
import com.example.userservice.Vo.ResponseTemplateVo;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;

@Service
public class UserService {
	
@Autowired
private UserRepository userRepository;

@Autowired
private RestTemplate restTemplate;

public User saveUser(User user) {
	
	return userRepository.save(user);
}

public  ResponseTemplateVo getUserWithDepartment(Long userId) {
	
	ResponseTemplateVo vo=new ResponseTemplateVo();
	
	User user =userRepository.findByUserId(userId);
	Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/ "+ user.getUserId(),Department.class);
	
	vo.setUser(user);
	vo.setDepartment(department);
	
	return vo;
}

	
	
}
