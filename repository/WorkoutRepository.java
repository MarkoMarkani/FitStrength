package com.fit.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fit.model.Workout;

import com.fit.model.Workout;
import com.fit.model.User;
@Transactional
@Repository
public interface WorkoutRepository extends CrudRepository<Workout,Long>{
	
	 public List<Workout> findByUser(User user);
	 
	 public List<Workout>findByWorkoutDate(Date workoutDate);
	 

}


