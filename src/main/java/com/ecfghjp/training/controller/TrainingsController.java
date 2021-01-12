package com.ecfghjp.training.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecfghjp.training.entities.Training;
import com.ecfghjp.training.exception.TrainingNotFoundException;
import com.ecfghjp.training.service.TrainingsService;

@RestController
@RequestMapping("/training")
public class TrainingsController {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

	@Autowired
	private TrainingsService trainingsService;

	@PostMapping("/")
	public Training saveTraining(@Valid @RequestBody Training training) {
		logger.info("Inside training controller method save training");
		return trainingsService.saveTraining(training);
	}

	@PostMapping("/search")
	public List<Training> findTrainings(@RequestBody Training training) throws Exception {
		logger.info("Inside training controller method find trainings");

		List<Training> trainings = trainingsService.findAllTrainings(training);
		if (null == trainings) {
			throw new TrainingNotFoundException("Training with team:" + training.getTrainingId() + " not found");
		} else {
			return trainings;
		}
	}
}
