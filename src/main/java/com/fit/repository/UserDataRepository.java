package com.fit.repository;

/**
*
* @author Marko
*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fit.model.UserData;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {

}
