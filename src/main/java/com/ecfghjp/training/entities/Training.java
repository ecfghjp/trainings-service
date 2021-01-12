package com.ecfghjp.training.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	
	@NotNull(message="Training Team should be one of the relevent Teams")
	private TEAM trainingTeam;
	
	@NotNull(message = "training link is not valid")
	private String trainingLink;
	
	@NotNull(message = "training platform  is not valid")
	private String trainingPlatform;
	
	@NotNull(message = "training environment is not valid")
	private String trainingEnvironment;
	
	@NotNull(message = "training category is not valid")
	private TRAINING_CATEGORY trainingCategory;
}
