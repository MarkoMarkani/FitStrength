package com.fit.repository;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fit.model.User;

/**
*
* @author Marko
*/
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	public User findUserByUsername(String username);

}
