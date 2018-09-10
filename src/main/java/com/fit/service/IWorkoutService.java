package com.fit.service;

import java.util.List;

/**
*
* @author Marko
*/

import com.fit.model.UserData;
import com.fit.model.Workout;

/**
*
* @author Marko
*/
public interface IWorkoutService {
	

public List<Workout>updateWorkouts(List<Workout>workouts);	

public List<Workout>getWorkouts();
public Workout addWorkout(Workout workout);
public void deleteWorkouts(List<Long>ids); 
public Long userBMI(UserData userData);
public void saveUserBMI(UserData userData);
public Long userBMR(UserData userData);
public void saveUserBMR(UserData userData);
}
