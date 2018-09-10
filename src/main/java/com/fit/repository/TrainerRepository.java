package com.fit.repository;

/**
*
* @author Marko
*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fit.model.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {

}
