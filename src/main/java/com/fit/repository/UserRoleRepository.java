package com.fit.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.fit.model.UserRole;

/**
*
* @author Marko
*/
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long>{


	

}
