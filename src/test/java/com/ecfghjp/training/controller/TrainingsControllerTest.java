package com.ecfghjp.training.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ecfghjp.training.entities.TEAM;
import com.ecfghjp.training.entities.TRAINING_CATEGORY;
import com.ecfghjp.training.entities.Training;
import com.ecfghjp.training.exception.ApiError;
import com.ecfghjp.training.exception.GlobalExceptionHandler;
import com.ecfghjp.training.service.TrainingsService;
import com.fasterxml.jackson.databind.ObjectMapper;

class TrainingsControllerTest {

	@InjectMocks
	private TrainingsController trainingsController;

	@Mock
	private TrainingsService trainingsService;

	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenSaveTraining_ThenSave() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("jsonObject").getFile());
		String json = readFile(file.getAbsolutePath(), Charset.defaultCharset());
		ObjectMapper objectMapper = new ObjectMapper();
		Training training = objectMapper.readValue(json, Training.class);
		
		Mockito.when(trainingsService.saveTraining(Mockito.any())).thenReturn(training);
		
		Training trainingVal = trainingsController.saveTraining(training);
		
		assertEquals(trainingVal.getTrainingId().longValue(), 1L);
		assertEquals(trainingVal.getTrainingCategory(), TRAINING_CATEGORY.AWS_DEV);
		assertEquals(trainingVal.getTrainingEnvironment(), "Local");
		assertEquals(trainingVal.getTrainingLink(), "http://abc.com");
		assertEquals(trainingVal.getTrainingPlatform(), "Online");
		assertEquals(trainingVal.getTrainingTeam(), TEAM.SENIOR_DEV);
		assertEquals(trainingVal.getTrainingName(), "AWS Lambda");



	}
	
	private String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
