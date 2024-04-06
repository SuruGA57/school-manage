package com.spring.schoolmanagement.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.schoolmanagement.enums.UserRole;
import com.spring.schoolmanagement.model.User;
import com.spring.schoolmanagement.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AdminServiceImpl {

	@Autowired
	UserRepository userRepository;
	
	@PostConstruct
	public void createAdminAccount() {
		
		User adminAccount =userRepository.findByRole(UserRole.ADMIN);
		if(adminAccount == null) {
			
		User admin=new User() ;
		admin.setEmail("admin@test.com");
		admin.setName("admin");
		admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
		admin.setRole(UserRole.ADMIN);
		
		userRepository.save(admin);}
		
	}
}
