package lk.himash.service;

import org.springframework.http.ResponseEntity;

import lk.himash.entity.User;

public interface UserService {

	ResponseEntity<?> getAllUsers();
	ResponseEntity<?> saveUser(User user);
	ResponseEntity<?> getUser(String id);
	
}
