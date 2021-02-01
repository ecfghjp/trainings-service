package com.ecfghjp.training.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CollectionType;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long trainingId;
	
	@NotNull(message="Training Name is required")
	private String trainingName;
	
	@ElementCollection
	@NotNull(message="Training Team should be one of the relevent Teams")
	private List<TrainingFor> trainingTargettedFor;
	
	@NotNull(message = "training link is not valid")
	private String trainingLink;
	
	@NotNull(message = "training platform  is not valid")
	private String trainingPlatform;
	
	@NotNull(message = "training environment is not valid")
	private String trainingEnvironment;
	
	@ElementCollection
	@NotNull(message = "training category is not valid")
	private List<TrainingCategory> trainingCategories;
	
	private int excpectedMaxNumberOfDays=20;
}
