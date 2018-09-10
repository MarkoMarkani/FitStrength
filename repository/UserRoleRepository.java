package com.fit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.fit.model.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long>{

//	public List<Role>findRoleByUserName(String username);
	

}
