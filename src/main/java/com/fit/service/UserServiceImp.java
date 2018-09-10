package com.fit.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.model.User;
import com.fit.repository.UserRepository;
import com.fit.repository.UserRoleRepository;

/**
 *
 * @author Marko
 */
@Service
@Transactional
public class UserServiceImp implements IUserService {

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;

	@Autowired
	public UserServiceImp(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public List<User> findUsers() {
		List<User> users = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}

	public void saveUser(User user) {
		user.setUsername(user.getUsername());
		// user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		userRepository.save(user);
	}

	public User findUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User getCurrentUser() {
		User currentUser = new User();
		return currentUser;
	}

}
