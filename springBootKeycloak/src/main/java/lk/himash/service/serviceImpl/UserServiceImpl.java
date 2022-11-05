package lk.himash.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lk.himash.entity.User;
import lk.himash.repository.UserRepository;
import lk.himash.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

//	@Autowired
	private final UserRepository userRepo;
	
	@Override
	public ResponseEntity<?> getAllUsers() {
		List<User> users = userRepo.findAll();
		log.info("users from databse : " + users);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> saveUser(User user) {
		User addedUser = userRepo.save(user);
		log.info("Added user details : " + addedUser);
		return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getUser(String id) {
		User user = userRepo.findById(id).get();
		log.info("Retrieve user details : " + user);
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

}
