package com.ecfghjp.training.service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecfghjp.training.entities.Training;
import com.ecfghjp.training.repository.TrainingsRepository;
import com.ecfghjp.training.repository.filter.TrainingQuerySpecs;


@Service
public class TrainingsServiceImpl implements TrainingsService {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

	@Autowired
	private TrainingsRepository trainingsRepository;
	
	@Autowired
	private TrainingQuerySpecs trainingQuerySpecs;
	
	

	public TrainingsServiceImpl(TrainingsRepository trainingsRepository,TrainingQuerySpecs trainingQuerySpecs) {
		this.trainingsRepository = trainingsRepository;
		this.trainingQuerySpecs = trainingQuerySpecs;
	}

	public Training saveTraining(Training training) {
		// TODO Auto-generated method stub
		logger.info("Inside training service method save training");

		return trainingsRepository.save(training);
	}

	@Override
	public List<Training> findAllTrainings(Training training) {
		// TODO Auto-generated method stub
		return trainingQuerySpecs.getTrainings(training);
	}

}
