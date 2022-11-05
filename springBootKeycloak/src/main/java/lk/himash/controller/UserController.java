package lk.himash.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.himash.entity.User;
import lk.himash.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/allUsers")
	@RolesAllowed("user")
	public ResponseEntity<?> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/addUser")
	@RolesAllowed("admin")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/getUser/{id}")
	@RolesAllowed("admin")
	public ResponseEntity<?> addUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
}
