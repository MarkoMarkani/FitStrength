package com.fit.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fit.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	public User findUserByUsername(String username);
	public List<User>findUserByEmail(String email);

}
