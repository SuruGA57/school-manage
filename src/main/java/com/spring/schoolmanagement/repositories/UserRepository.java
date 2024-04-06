package com.spring.schoolmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.schoolmanagement.enums.UserRole;
import com.spring.schoolmanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByRole(UserRole userRole);

}
