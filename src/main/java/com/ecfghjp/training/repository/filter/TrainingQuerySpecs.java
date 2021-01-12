package com.ecfghjp.training.repository.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecfghjp.training.entities.Training;
import com.ecfghjp.training.repository.TrainingsRepository;
import com.ecfghjp.training.repository.SearchObjects.SearchCriterea;
import com.ecfghjp.training.repository.SearchObjects.SearchOperation;

@Component
public class TrainingQuerySpecs {

	@Autowired
	TrainingsRepository trainingsRepository;

	public List<Training> getTrainings(Training training) {
		List<Training> trainingsList = new ArrayList<>();
		TrainingSpecificationImpl trainingSpecificationImpl = new TrainingSpecificationImpl();
		if (training.getTrainingId() != null) {
			trainingSpecificationImpl
					.add(new SearchCriterea("trainingId", training.getTrainingId(), SearchOperation.EQUAL));
		}
		if(training.getTrainingName()!=null) {
			trainingSpecificationImpl
			.add(new SearchCriterea("trainingName", training.getTrainingName(), SearchOperation.MATCH));
		}
		if(training.getTrainingTeam()!=null) {
			trainingSpecificationImpl
			.add(new SearchCriterea("trainingTeam", training.getTrainingTeam(), SearchOperation.EQUAL));
		}
		
		trainingsList = trainingsRepository.findAll(trainingSpecificationImpl);
		return trainingsList;

	}

}
