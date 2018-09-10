package com.fit.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fit.model.Program;
import com.fit.model.Trainer;
import com.fit.model.User;
import com.fit.model.Workout;
import com.fit.service.TrainerServiceImp;
import com.fit.service.UserServiceImp;
import com.fit.service.WorkoutServiceImp;

/**
 *
 * @author Marko
 */
@Controller
public class FitController {
	@Autowired
	private WorkoutServiceImp workoutService;

	@Autowired
	UserServiceImp userService;

	@Autowired
	TrainerServiceImp trainerService;

	@GetMapping("/")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "home";
	}

	@PostMapping("/")
	public String loginForm(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Incorrect username or password");

			return "home";
		}
		return "newworkout";
	}

	@GetMapping("/sign-up")
	public String registerUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/sign-up")
	public String registerUserForm(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {

		return "newworkout";

	}

	@GetMapping("/all-workouts")
	public String allworkouts(Model model) {
		model.addAttribute("workouts", workoutService.findWorkouts());
		return "workouts";
	}

	@GetMapping("/new-workout")
	public String newworkout(Model model, @ModelAttribute Workout workout) {
		model.addAttribute("programs", Program.values());
		model.addAttribute("trainers", trainerService.findTrainers());
		workoutService.findWorkoutPrograms();
		return "newworkout";
	}

	@PostMapping("/new-workout")
	public String addWorkout(@Valid @ModelAttribute Workout workout, BindingResult bindingResult,
			@RequestParam Long trainerId, Model model) {
		workout.setDateCreated(new Date());
		Trainer trainer = trainerService.findTrainer(trainerId);
		workout.setTrainer(trainer);
		workoutService.findWorkoutPrograms();
		workoutService.saveWorkout(workout);
		model.addAttribute("trainers", trainerService.findTrainers());

		return "workouts";
	}

	@GetMapping("/all-trainers")
	public String trainers(Model model) {
		model.addAttribute("trainers", trainerService.findTrainers());

		return "trainers";

	}

	@GetMapping("/delete-workout")
	public String deleteworkout(@RequestParam Long workoutId, Model model) {
		workoutService.deleteWorkout(workoutId);
		model.addAttribute("workouts", workoutService.findWorkouts());
		return "workouts";
	}

	@GetMapping("/about-us")
	public String aboutUs(Model model) {
		return "about";
	}

	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
}