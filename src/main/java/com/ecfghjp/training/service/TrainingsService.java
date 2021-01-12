package com.ecfghjp.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecfghjp.training.entities.TEAM;
import com.ecfghjp.training.entities.Training;

@Service
public interface TrainingsService {
	
	Training saveTraining(Training department);

	Training findTrainingById(Long departmentId);
	
	Training findTrainingByName(String trainingName);
	
	Training findTrainingByTeam(TEAM trainingTeam);
	
	List<Training> findAllTrainings(Training training);


	
}
