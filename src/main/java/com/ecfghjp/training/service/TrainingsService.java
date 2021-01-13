package com.ecfghjp.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecfghjp.training.entities.Training;

@Service
public interface TrainingsService {
	
	Training saveTraining(Training department);
	
	List<Training> findAllTrainings(Training training);


	
}
