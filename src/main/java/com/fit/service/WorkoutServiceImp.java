package com.fit.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.model.User;
import com.fit.model.UserData;
import com.fit.model.Workout;
import com.fit.repository.WorkoutRepository;
import com.fit.repository.UserDataRepository;
import com.fit.repository.UserRepository;

/**
 *
 * @author Marko
 */
@Service
public class WorkoutServiceImp implements IWorkoutService {

	private UserRepository userRepository;
	private IUserService userService;
	private WorkoutRepository workoutRepository;
	private UserDataRepository userDataRepository;

	@Autowired
	public WorkoutServiceImp(UserRepository userRepository, WorkoutRepository workoutRepository,
			IUserService userService, UserDataRepository userDataRepository) {
		super();
		this.userRepository = userRepository;
		this.workoutRepository = workoutRepository;
		this.userService = userService;
		this.userDataRepository = userDataRepository;
	}

	public List<Workout> getWorkouts() {
		User currentUser = userService.getCurrentUser();

		List<Workout> workoutList = workoutRepository.findByUser(currentUser);
		for (Workout workout : workoutList) {
			workoutList.add(workout); ////// ???????trebace jos?????

		}

		return workoutList;
	}

	public List<UserData> findUserDatas() {
		List<UserData> datas = new ArrayList<>();
		for (UserData userdata : userDataRepository.findAll()) {
			datas.add(userdata);
		}
		return datas;
	}

	public List<Workout> findWorkouts() {
		List<Workout> workouts = new ArrayList<>();
		for (Workout workout : workoutRepository.findAll()) {
			workouts.add(workout);
		}
		return workouts;
	}

	public List<Workout> findWorkoutPrograms() {
		List<Workout> workouts = new ArrayList<>();
		for (Workout workout : workoutRepository.findAll()) {
			if (workout.getProgram().equals(workout.getTrainer().getProgram())) {
				workouts.add(workout);
			}
		}
		return workouts;
	}

	public void deleteWorkout(Long workoutId) {
		workoutRepository.deleteById(workoutId);

	}

	public void updateWorkout(Long workoutId, Workout workout) {
		workoutRepository.save(workout);

	}

	public void saveWorkout(Workout workout) {
		workoutRepository.save(workout);

	}

	@Override
	public List<Workout> updateWorkouts(List<Workout> workouts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWorkouts(List<Long> ids) {
		// TODO Auto-generated method stub
	}

	public Workout findWorkout(Long workoutId) {
		return workoutRepository.findById(workoutId).orElse(null);
	}

	@Override
	public Workout addWorkout(Workout workout) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long userBMI(UserData userData) {
		Long weight = userData.getWeight();
		Long height = userData.getHeight();
		Long result = weight / (height / 100) * (weight / 100);
		return result;
	}

	@Override
	public void saveUserBMI(UserData userData) {
		userData.setWeight(userData.getWeight());
		userData.setHeight(userData.getHeight());
		userDataRepository.save(userData);
	}

	@Override
	public Long userBMR(UserData userData) {

		return null;
	}

	@Override
	public void saveUserBMR(UserData userData) {
		// TODO Auto-generated method stub

	}

}
