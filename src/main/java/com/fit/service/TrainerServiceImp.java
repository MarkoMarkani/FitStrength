package com.fit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.model.Trainer;
import com.fit.repository.TrainerRepository;

/**
 *
 * @author Marko
 */
@Service
public class TrainerServiceImp {

	@Autowired
	private TrainerRepository trainerRepository;

	public Trainer findTrainer(Long trainerId) {
		return trainerRepository.findById(trainerId).orElse(null);
	}

	public List<Trainer> findTrainers() {

		List<Trainer> trainers = new ArrayList<>();
		for (Trainer trainer : trainerRepository.findAll()) {
			trainers.add(trainer);
		}

		return trainers;
	}
}
